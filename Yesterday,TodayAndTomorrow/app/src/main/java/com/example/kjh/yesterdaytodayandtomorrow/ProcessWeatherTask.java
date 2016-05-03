package com.example.kjh.yesterdaytodayandtomorrow;

import android.os.AsyncTask;
import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by kjh on 2016-04-28.
 */
public class ProcessWeatherTask extends AsyncTask<Void, Void, Void> {
    @Override
    protected Void doInBackground(Void... params)
    {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=109");
            if(document != null){
                NodeList list = document.getElementsByTagName("data");
                Log.d("YTT", "차일드 노드의 엘리먼트 수"+list.item(0).getChildNodes().getLength());
                for(int i = 0; i < list.getLength(); i++){
                    Log.d("YTT", "==="+list.item(i).getAttributes().getNamedItem("seq").getTextContent()+"===");
                    //childNode 출력
                    for(int k = 0; k < list.item(i).getChildNodes().getLength(); k++){
                        if(list.item(i).getChildNodes().item(k).getNodeType() == Node.ELEMENT_NODE){
                            Log.d("YTT", k+":"+list.item(i).getChildNodes().item(k).getNodeName()+"====>");
                            Log.d("YTT", list.item(i).getChildNodes().item(k).getTextContent());
                        }
                    }
                }
            }
        }catch (Exception e){
            Log.d("YTT", e.getMessage());
        }

        return null;
    }
}
