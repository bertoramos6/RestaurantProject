package Presentacion.Command.Ingrediente;

import Negocio.FactoriaNegocio.FactoriaSA;
import Negocio.Ingrediente.SAIngrediente;
import Negocio.Ingrediente.TIngrediente;
import Presentacion.Command.Command;
import Presentacion.Command.Context;
import Presentacion.Controller.Events;

public class EditarIngrediente2Command implements Command {

	@Override
	public Context executeCommand(Object data) {
		FactoriaSA fsa = FactoriaSA.getInstance();
		SAIngrediente saIngr = fsa.generarSAIngrediente();
		int res = saIngr.editar((TIngrediente) data);
		
		Context resContext = null;
		String mensaje;
		if (res == -1) {
			mensaje = "El ingrediente no ha podido ser editado";
			resContext = new Context(Events.MODIFICAR_INGREDIENTE_KO, mensaje);
		}
		else {
			mensaje = "Ingrediente edita con exito" ;
			resContext = new Context(Events.MODIFICAR_INGREDIENTE_OK, res);
		}
		
		return resContext;
	}
}