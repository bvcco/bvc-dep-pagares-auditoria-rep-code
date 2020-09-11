package com.deceval.auditoria.web.filtro;

public class ValidadorIp {

    /**
     * Si existe mas de una ip, retorna la primera
     * @param ipEnHeader
     * @return
     */
    public static String obtenerIpDeHeader( String ipEnHeader ) {
        boolean multipleIp = ipEnHeader.contains(",");
        return multipleIp?
                ipEnHeader.trim().replaceAll(" ", "").split(",")[0] :
                ipEnHeader.trim().replaceAll(" ", "");
    }
}
