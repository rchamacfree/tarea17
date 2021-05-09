/*
Modifica el archivo XML ‘librería.xml’ pasando el alto y el ancho a pulgadas. Guárdalo 
con el nombre ‘libreriaPulgadas.xml’ 

Fecha:09/05/2021
Alumno: Rafael Chamorro Maceiras
 */
package rcmt17;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 *
 * @author rchamac
 */
public class RCMt17e11 {

    static final float CM_PULG = 2.54f;

    public static void main(String[] args) {

        File file = new File("Archivos" + File.separator + "libreria.xml");
        try ( FileInputStream fis = new FileInputStream(file);  InputStreamReader isr = new InputStreamReader(fis, "UTF-8")) {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dB = factory.newDocumentBuilder();
            Document doc = dB.parse(new InputSource(isr));

            NodeList lista = doc.getElementsByTagName("dimensiones");
            for (int i = 0; i < lista.getLength(); i++) {
                Element dimensiones = (Element) lista.item(i);

                if (dimensiones.hasAttribute("alto")) {
                    String alto = dimensiones.getAttribute("alto");
                    float alto_pul = Float.parseFloat(alto) / CM_PULG;
                    dimensiones.setAttribute("alto", String.valueOf(alto_pul));
                }
                
                if (dimensiones.hasAttribute("ancho")) {
                    String ancho = dimensiones.getAttribute("ancho");
                    float ancho_pul = Float.parseFloat(ancho) / CM_PULG;
                    dimensiones.setAttribute("ancho", String.valueOf(ancho_pul));
                }

            }

            //Guardamos el archivo.
            File ficheroSalida = new File("Archivos" + File.separator + "libreriaPulgadas.xml");
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.transform(new DOMSource(doc), new StreamResult(ficheroSalida));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
