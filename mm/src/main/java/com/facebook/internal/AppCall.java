package com.facebook.internal;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.UUID;

public class AppCall {
    private static AppCall currentPendingCall;
    private UUID callId;
    private int requestCode;
    private Intent requestIntent;

    public static AppCall getCurrentPendingCall() {
        return currentPendingCall;
    }

    public static synchronized AppCall finishPendingCall(UUID uuid, int i2) {
        AppCall currentPendingCall2;
        synchronized (AppCall.class) {
            AppMethodBeat.i(7633);
            currentPendingCall2 = getCurrentPendingCall();
            if (currentPendingCall2 == null || !currentPendingCall2.getCallId().equals(uuid) || currentPendingCall2.getRequestCode() != i2) {
                AppMethodBeat.o(7633);
                currentPendingCall2 = null;
            } else {
                setCurrentPendingCall(null);
                AppMethodBeat.o(7633);
            }
        }
        return currentPendingCall2;
    }

    private static synchronized boolean setCurrentPendingCall(AppCall appCall) {
        boolean z;
        synchronized (AppCall.class) {
            AppMethodBeat.i(7634);
            AppCall currentPendingCall2 = getCurrentPendingCall();
            currentPendingCall = appCall;
            if (currentPendingCall2 != null) {
                z = true;
                AppMethodBeat.o(7634);
            } else {
                z = false;
                AppMethodBeat.o(7634);
            }
        }
        return z;
    }

    public AppCall(int i2) {
        this(i2, UUID.randomUUID());
        AppMethodBeat.i(7635);
        AppMethodBeat.o(7635);
    }

    public AppCall(int i2, UUID uuid) {
        this.callId = uuid;
        this.requestCode = i2;
    }

    public Intent getRequestIntent() {
        return this.requestIntent;
    }

    public UUID getCallId() {
        return this.callId;
    }

    public int getRequestCode() {
        return this.requestCode;
    }

    public void setRequestCode(int i2) {
        this.requestCode = i2;
    }

    public void setRequestIntent(Intent intent) {
        this.requestIntent = intent;
    }

    public boolean setPending() {
        AppMethodBeat.i(7636);
        boolean currentPendingCall2 = setCurrentPendingCall(this);
        AppMethodBeat.o(7636);
        return currentPendingCall2;
    }
}
