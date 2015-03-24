package aspectosprofesionales.metroapp;

import android.text.format.Time;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
/**
 * Created by xabier on 17/03/15.
 */
public class XMLPullParserHandler {

    List<Estation> estations;

    private Estation estation;

    public XMLPullParserHandler(){
        estations=new ArrayList<Estation>();

    }

    public List<Estation> parse(InputStream is){
        XmlPullParserFactory factory=null;
        XmlPullParser parser=null;

        try {
            factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            parser=factory.newPullParser();
            parser.setInput(is, null);

            boolean wasL1=false;
            int eventType =parser.getEventType();
            String text="";
            Line line=new Line();
            Integer minute=0;
            String nestTag;
            DateFormat formatter = new SimpleDateFormat("hh:mm:ss a");

            // Datos con el siguiente formato: "08:03:10 am"

               Date date=null;

            while(eventType !=XmlPullParser.END_DOCUMENT){
                String tagname= parser.getName();
                   switch (eventType){
                       case XmlPullParser.START_TAG:
                           if(tagname.equalsIgnoreCase("estation")){
                               if(estation!=null){
                               estations.add(estation);}
                               estation=new Estation();
                            break;
                           }
                       case XmlPullParser.TEXT:
                           nestTag=parser.getText();
                           if(nestTag.contains(":")){
                               date = formatter.parse(nestTag);
                           }else if(nestTag.contains("0")) {
                               minute=Integer.parseInt(nestTag);
                           }else{
                                   text=nestTag;
                           }
                           break;
                       case XmlPullParser.END_TAG:
                           if (tagname.equalsIgnoreCase("estation")){
                               estations.add(estation);
                           }else if(tagname.equalsIgnoreCase("name")){
                               estation.setName(text);
                           }else if(tagname.equalsIgnoreCase("Line1")){
                                estation.setLine1(line);
                               wasL1=true;
                           }else if(tagname.equalsIgnoreCase("Line2")) {
                               estation.setLine2(line);
                               wasL1=false;
                           }else if(tagname.equalsIgnoreCase("leftFirst")){
                               if(wasL1){
                                   estation.getLine1().setLeftFirst(date);
                               }else {
                                   estation.getLine2().setLeftFirst(date);
                               }
                           }else if(tagname.equalsIgnoreCase("leftFrecuency")){
                               if(wasL1){
                                   estation.getLine1().setLeftFrecuency(minute);
                               }else {
                                   estation.getLine2().setLeftFrecuency(minute);
                               };
                           }else if(tagname.equalsIgnoreCase("rightFirst")){
                               if(wasL1){
                                   estation.getLine1().setRightFirst(date);
                               }else {
                                   estation.getLine2().setRightFirst(date);
                               }
                           }else if(tagname.equalsIgnoreCase("rightFrecuency")){
                               if(wasL1){
                                   estation.getLine1().setRightFrecuency(minute);
                               }else {
                                   estation.getLine2().setRightFrecuency(minute);
                               };
                           }
                           break;
                   }
                        eventType = parser.next();

            }  estations.add(estation);

        }catch (Exception e){
            e.printStackTrace();
        }

        return estations;



    }


}
