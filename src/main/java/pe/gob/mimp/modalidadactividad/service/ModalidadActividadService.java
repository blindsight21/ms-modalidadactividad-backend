/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.modalidadactividad.service;

import java.math.BigDecimal;
import java.util.List;
import pe.gob.mimp.modalidadactividad.bean.FindByParamBean;
import pe.gob.mimp.modalidadactividad.bean.ModalidadActividadBean;

/**
 *
 * @author Omar
 */
public interface ModalidadActividadService {

    void crearModalidadActividad(ModalidadActividadBean modalidadActividadBean) throws Exception;

    void editarModalidadActividad(ModalidadActividadBean modalidadActividadBean) throws Exception;

//    void anularModalidadActividad(ModalidadActividadBean modalidadActividadBean) throws Exception;
    String obtenerModalidadActividadPorId(BigDecimal nidModalidadActividad) throws Exception;

    List<ModalidadActividadBean> loadModalidadActividadList(FindByParamBean findByParamBean) throws Exception;

    Integer getRecordCount(FindByParamBean findByParamBean) throws Exception;

    ModalidadActividadBean find(BigDecimal id);
}
