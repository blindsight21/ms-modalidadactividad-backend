/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.modalidadactividad.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mimp.siscap.model.ModalidadActividad;
import pe.gob.mimp.siscap.repository.modalidadactividad.ModalidadActRepository;
import pe.gob.mimp.modalidadactividad.bean.FindByParamBean;
import pe.gob.mimp.modalidadactividad.bean.ModalidadActividadBean;
import pe.gob.mimp.modalidadactividad.converter.ModalidadActividadCast;
import pe.gob.mimp.modalidadactividad.util.Util;
import pe.gob.mimp.modalidadactividad.service.ModalidadActividadService;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class ModalidadActividadServiceImpl implements ModalidadActividadService {

    @Autowired
    private ModalidadActRepository modalidadActividadRepository;

    @Override
    public void crearModalidadActividad(ModalidadActividadBean modalidadActividadBean) throws Exception {

        ModalidadActividad modalidadActividad = new ModalidadActividad();
        modalidadActividad.setTxtModalidadActividad(modalidadActividadBean.getTxtModalidadActividad());
        modalidadActividad.setNidUsuario(modalidadActividadBean.getNidUsuario());
        modalidadActividad.setTxtPc(modalidadActividadBean.getTxtPc());
        modalidadActividad.setTxtIp(modalidadActividadBean.getTxtIp());
        modalidadActividad.setFecEdicion(modalidadActividadBean.getFecEdicion());
        modalidadActividad.setFlgActivo(modalidadActividadBean.getFlgActivo());

        modalidadActividadRepository.save(modalidadActividad);

    }

    @Override
    public void editarModalidadActividad(ModalidadActividadBean modalidadActividadBean) {

        ModalidadActividad modalidadActividad = new ModalidadActividad();

        modalidadActividad.setNidModalidadActividad(modalidadActividadBean.getNidModalidadActividad());
        modalidadActividad.setTxtModalidadActividad(modalidadActividadBean.getTxtModalidadActividad());
        modalidadActividad.setNidUsuario(modalidadActividadBean.getNidUsuario());
        modalidadActividad.setTxtPc(modalidadActividadBean.getTxtPc());
        modalidadActividad.setTxtIp(modalidadActividadBean.getTxtIp());
        modalidadActividad.setFecEdicion(modalidadActividadBean.getFecEdicion());
        modalidadActividad.setFlgActivo(modalidadActividadBean.getFlgActivo());

        modalidadActividadRepository.save(modalidadActividad);

    }

    @Override
    public String obtenerModalidadActividadPorId(BigDecimal nidModalidadActividad) throws Exception {

        Optional<ModalidadActividad> modalidadActividad = modalidadActividadRepository.findById(nidModalidadActividad);

        if (modalidadActividad.isPresent()) {
            return modalidadActividad.get().getTxtModalidadActividad();
        }

        return "";
    }

    @Override
    public List<ModalidadActividadBean> loadModalidadActividadList(FindByParamBean findByParamBean) throws Exception {

        if (findByParamBean.getParameters() == null) {
            findByParamBean.setParameters(new HashMap<>());
        }

        List<ModalidadActividad> modalidadActividadList = modalidadActividadRepository.findByParams(findByParamBean.getParameters(), findByParamBean.getOrderBy());

        if (!Util.esListaVacia(modalidadActividadList)) {

            return modalidadActividadList.stream().map(modalidadActividad -> {
                ModalidadActividadBean modalidadActividadBean = new ModalidadActividadBean();
                modalidadActividadBean.setNidModalidadActividad(modalidadActividad.getNidModalidadActividad());
                modalidadActividadBean.setTxtModalidadActividad(modalidadActividad.getTxtModalidadActividad());
                modalidadActividadBean.setNidUsuario(modalidadActividad.getNidUsuario());
                modalidadActividadBean.setTxtPc(modalidadActividad.getTxtPc());
                modalidadActividadBean.setTxtIp(modalidadActividad.getTxtIp());
                modalidadActividadBean.setFecEdicion(modalidadActividad.getFecEdicion());
                modalidadActividadBean.setFlgActivo(modalidadActividad.getFlgActivo());
                return modalidadActividadBean;
            }).collect(Collectors.toList());
        }

        return null;
    }

    @Override
    public Integer getRecordCount(FindByParamBean findByParamBean) throws Exception {

        if (findByParamBean.getParameters() == null) {
            findByParamBean.setParameters(new HashMap<>());
        }
        Integer count = modalidadActividadRepository.getRecordCount(findByParamBean.getParameters());
        return count;
    }

    @Override
    public ModalidadActividadBean find(BigDecimal id) {

        Optional<ModalidadActividad> modalidadActividad = modalidadActividadRepository.findById(id);

        if (!modalidadActividad.isPresent()) {
            return null;
        }

        return ModalidadActividadCast.castModalidadActividadToModalidadActividadBean(modalidadActividad.get());

    }

}
