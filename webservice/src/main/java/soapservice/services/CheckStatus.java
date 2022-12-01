package soapservice.services;

import javax.jws.WebService;
import javax.jws.WebMethod; 
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
// public class checkStatus {
//     @WebMeth: " + status;
//     }od
//     public String checkStatus(String status) {
//         return "Status
// }

public interface CheckStatus {
    @WebMethod
    public String CheckStatusDB();
    public String HelloWorld(String name);
}

