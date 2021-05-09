/*
Crea un archivo XML desde cero que solo contenga un elemento raíz llamado 
<agenda> y elementos hijo de tipo texto como los que muestra la siguiente figura
 <agenda>
    <contacto>Pepe Perez</contacto>
    <contacto>Ana Lopez</contacto>
</agenda>

Fecha:09/05/2021
Alumno: Rafael Chamorro Maceiras
 */
package rcmt17;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class RCMt17e14 {

    public static void main(String[] args) throws ParserConfigurationException, TransformerConfigurationException, TransformerException {

       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
       DocumentBuilder dB = factory.newDocumentBuilder();
       Document doc = dB.newDocument();
       
       Element raiz = doc.createElement("agenda");
       doc.appendChild(raiz);
       
       Element contacto = doc.createElement("contacto");
       contacto.appendChild(doc.createTextNode("Pepe Pérez"));
       raiz.appendChild(contacto);
       
       Element contacto1 = doc.createElement("contacto");
       contacto1.appendChild(doc.createTextNode("Ana López"));
       raiz.appendChild(contacto1);
       
       
        
       File ficheroSalida = new File("Archivos" + File.separator + "agenda.xml");
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.transform(new DOMSource(doc), new StreamResult(ficheroSalida));
    }

}
