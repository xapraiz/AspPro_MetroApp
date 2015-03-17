package aspectosprofesionales.metroapp;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
/**
 * Created by xabier on 17/03/15.
 */
public class XMLPullParserHandler {

    List<Estation> estations;

    private Estation estation;
    private String text;

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
            while(eventType !=XmlPullParser.END_DOCUMENT){
                String tagname= parser.getName();
                   switch (eventType){
                       case XmlPullParser.START_TAG:
                           if(tagname.equalsIgnoreCase("estation")){
                               if(estation!=null){
                               estations.add(estation)}
                               estation=new Estation();
                            break;
                           }
                       case XmlPullParser.TEXT:
                           text=parser.getText();
                           break;
                       case XmlPullParser.END_TAG:
                           if (tagname.equalsIgnoreCase("estation")){
                               estations.add(estation);
                           }else if(tagname.equalsIgnoreCase("name")){
                               estation.setName(text);
                           }else if(tagname.equalsIgnoreCase("Line1")){
                                estation.addLine1(text);
                               wasL1=true;
                           }else if(tagname.equalsIgnoreCase("Line2")) {
                               estation.addLine2(text);
                               wasL1=false;
                           }else if(tagname.equalsIgnoreCase("leftFirst")){
                               if(wasL1){
                                   estation.getLine1().setLeftFirst(text);
                               }else {
                                   estation.getLine2().setLeftFirst(text);
                               }
                           }else if(tagname.equalsIgnoreCase("leftFrecuency")){
                               if(wasL1){
                                   estation.getLine1().setLeftFrecuency(text);
                               }else {
                                   estation.getLine2().setLeftFrecuency(text);
                               };
                           }else if(tagname.equalsIgnoreCase("rightFirst")){
                               if(wasL1){
                                   estation.getLine1().setRightFirst(text);
                               }else {
                                   estation.getLine2().setRightFirst(text);
                               }
                           }else if(tagname.equalsIgnoreCase("rightFrecuency")){
                               if(wasL1){
                                   estation.getLine1().setRightFrecuency(text);
                               }else {
                                   estation.getLine2().setRightFrecuency(text);
                               };
                           }
                           break;
                       default:
                           break;
                   }
                        eventType = parser.next();



            }estations.add(estation);



        }catch (Exception e){
            e.printStackTrace();
        }

        return estations;



    }


}
