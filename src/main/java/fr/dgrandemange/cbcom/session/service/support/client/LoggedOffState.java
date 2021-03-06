package fr.dgrandemange.cbcom.session.service.support.client;

import fr.dgrandemange.cbcom.exception.CBCOMSessionException;
import fr.dgrandemange.cbcom.session.model.PseudoSessionContext;
import fr.dgrandemange.cbcom.session.service.IPseudoSessionState;
import fr.dgrandemange.cbcom.session.service.support.PseudoSessionStateAbstractImpl;

/**
 * Logged off pseudo session state "client" implementation<BR>
 * 
 * @author dgrandemange
 * 
 */
public class LoggedOffState extends PseudoSessionStateAbstractImpl implements
		IPseudoSessionState {

	@Override
	public void init(PseudoSessionContext ctx) {
	}

	@Override
	public void onIpduABEmitted(PseudoSessionContext ctx, int abortCode) {
		// N/A
	}

	@Override
	public void onIpduABReceived(PseudoSessionContext ctx) {
	}

	@Override
	public void onIpduACEmitted(PseudoSessionContext ctx) {
		// N/A
	}

	@Override
	public void onIpduCNReceived(PseudoSessionContext ctx) {
		try {
			ctx.getChannelCallback().close();
		} catch (CBCOMSessionException e) {
			// Safe to ignore
			e.printStackTrace();
		}
	}

	@Override
	public void onIpduACReceived(PseudoSessionContext ctx) {
		try {
			ctx.getChannelCallback().close();
		} catch (CBCOMSessionException e) {
			// Safe to ignore
			e.printStackTrace();
		}
	}

	@Override
	public void onIpduCNEmitted(PseudoSessionContext ctx) {
		// N/A
	}

	@Override
	public void onIpduDEEmitted(PseudoSessionContext ctx) {
		// N/A
	}

	@Override
	public void onIpduDEReceived(PseudoSessionContext ctx) {
		try {
			ctx.getChannelCallback().close();
		} catch (CBCOMSessionException e) {
			// Safe to ignore
			e.printStackTrace();
		}
	}

	@Override
	public void onIpduDEToSend(PseudoSessionContext ctx) {
		changeState(ctx, InitialState.class);
		ctx.getSessionState().onIpduDEToSend(ctx);
	}

}
