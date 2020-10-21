/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.modalidadactividad.ws.rest;

import java.math.BigDecimal;
import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.mimp.modalidadactividad.bean.FindByParamBean;

import pe.gob.mimp.modalidadactividad.bean.ResponseData;
import pe.gob.mimp.modalidadactividad.bean.ModalidadActividadBean;
import pe.gob.mimp.modalidadactividad.service.ModalidadActividadService;

/**
 *
 * @author BlindSight
 */
@RestController
@RequestMapping(value = "/")
public class ModalidadActividadController {

    @Autowired
    private ModalidadActividadService modalidadActividadService;

    @PostMapping(value = "/crearModalidadActividad", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> crearModalidadActividad(@RequestBody ModalidadActividadBean modalidadActividadBean) throws Exception {

        modalidadActividadService.crearModalidadActividad(modalidadActividadBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.CREATED.value());
        response.setMsg(HttpStatus.CREATED.getReasonPhrase());

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/editarModalidadActividad", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> editarModalidadActividad(@RequestBody ModalidadActividadBean modalidadActividadBean) throws Exception {

        modalidadActividadService.editarModalidadActividad(modalidadActividadBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());

        return ResponseEntity.ok(response);

    }

    @GetMapping(value = "/obtenerModalidadActividadPorId/{nidModalidadActividad}")
    public ResponseEntity<ResponseData<?>> obtenerModalidadActividadPorId(@PathVariable("nidModalidadActividad") BigDecimal nidModalidadActividad) throws Exception {

        String txtModalidadActividad = modalidadActividadService.obtenerModalidadActividadPorId(nidModalidadActividad);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(txtModalidadActividad);

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/loadModalidadActividadList", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> loadModalidadActividadList(@RequestBody FindByParamBean findByParamBean) throws Exception {

        List<ModalidadActividadBean> modalidadActividadList = modalidadActividadService.loadModalidadActividadList(findByParamBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(modalidadActividadList);

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/getRecordCount", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> getRecordCount(@RequestBody FindByParamBean findByParamBean) throws Exception {

        Integer count = modalidadActividadService.getRecordCount(findByParamBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(count);

        return ResponseEntity.ok(response);

    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<ResponseData<?>> find(@PathVariable("id") BigDecimal id) throws Exception {

        ModalidadActividadBean modalidadActividadBean = modalidadActividadService.find(id);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(modalidadActividadBean);

        return ResponseEntity.ok(response);

    }

}
