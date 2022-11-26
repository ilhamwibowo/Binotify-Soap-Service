package soapservice.services;

import javax.jws.WebService;
import javax.jws.WebMethod; 
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
// public class checkStatus {
//     @WebMethod
//     public String checkStatus(String status) {
//         return "Status: " + status;
//     }
// }

public interface CheckStatus {
    @WebMethod
    public String CheckStatus(String status);
}

