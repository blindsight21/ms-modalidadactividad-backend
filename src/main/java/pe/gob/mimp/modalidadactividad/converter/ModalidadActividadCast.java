/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.modalidadactividad.converter;

import pe.gob.mimp.modalidadactividad.bean.ModalidadActividadBean;
import pe.gob.mimp.siscap.model.ModalidadActividad;

/**
 *
 * @author Omar
 */
public class ModalidadActividadCast {

    public static ModalidadActividadBean castModalidadActividadToModalidadActividadBean(ModalidadActividad tipoObjetivo) {

        if (tipoObjetivo == null) {
            return null;
        }

        ModalidadActividadBean tipoObjetivoBean = new ModalidadActividadBean();

        tipoObjetivoBean.setNidModalidadActividad(tipoObjetivo.getNidModalidadActividad());
        tipoObjetivoBean.setTxtModalidadActividad(tipoObjetivo.getTxtModalidadActividad());
        tipoObjetivoBean.setFlgActivo(tipoObjetivo.getFlgActivo());
        tipoObjetivoBean.setNidUsuario(tipoObjetivo.getNidUsuario());
        tipoObjetivoBean.setTxtPc(tipoObjetivo.getTxtPc());
        tipoObjetivoBean.setTxtIp(tipoObjetivo.getTxtIp());
        tipoObjetivoBean.setFecEdicion(tipoObjetivo.getFecEdicion());

        return tipoObjetivoBean;
    }

    public static ModalidadActividad castModalidadActividadBeanToModalidadActividad(ModalidadActividadBean tipoObjetivoBean) {

        if (tipoObjetivoBean == null) {
            return null;
        }

        ModalidadActividad tipoObjetivo = new ModalidadActividad();

        tipoObjetivo.setNidModalidadActividad(tipoObjetivoBean.getNidModalidadActividad());
        tipoObjetivo.setTxtModalidadActividad(tipoObjetivoBean.getTxtModalidadActividad());
        tipoObjetivo.setFlgActivo(tipoObjetivoBean.getFlgActivo());
        tipoObjetivo.setNidUsuario(tipoObjetivoBean.getNidUsuario());
        tipoObjetivo.setTxtPc(tipoObjetivoBean.getTxtPc());
        tipoObjetivo.setTxtIp(tipoObjetivoBean.getTxtIp());
        tipoObjetivo.setFecEdicion(tipoObjetivoBean.getFecEdicion());

        return tipoObjetivo;
    }
}
