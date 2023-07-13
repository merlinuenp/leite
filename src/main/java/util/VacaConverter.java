package util;

import dao.DaoVaca;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import modelo.Vaca;


@FacesConverter(value = "vacaConverter")
public class VacaConverter implements Converter {
    
@Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String nome) {
        Vaca temp = null;
        DaoVaca dao = new DaoVaca();
        try {
            temp = dao.buscarPorNome(nome);
	} catch (Exception e) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro","Selecione uma vaca"));
	}
 	return temp;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
        if (obj instanceof Vaca){
            Vaca v = (Vaca)obj;
            return v.getNome();
        }
        return "";
    }
    
}
