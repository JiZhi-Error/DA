package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.common.internal.ISignInButtonCreator;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class SignInButtonCreator extends RemoteCreator<ISignInButtonCreator> {
    private static final SignInButtonCreator zzuz = new SignInButtonCreator();

    static {
        AppMethodBeat.i(11874);
        AppMethodBeat.o(11874);
    }

    private SignInButtonCreator() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View createView(Context context, int i2, int i3) {
        AppMethodBeat.i(11870);
        View zza = zzuz.zza(context, i2, i3);
        AppMethodBeat.o(11870);
        return zza;
    }

    private final View zza(Context context, int i2, int i3) {
        AppMethodBeat.i(11871);
        try {
            SignInButtonConfig signInButtonConfig = new SignInButtonConfig(i2, i3, null);
            View view = (View) ObjectWrapper.unwrap(((ISignInButtonCreator) getRemoteCreatorInstance(context)).newSignInButtonFromConfig(ObjectWrapper.wrap(context), signInButtonConfig));
            AppMethodBeat.o(11871);
            return view;
        } catch (Exception e2) {
            RemoteCreator.RemoteCreatorException remoteCreatorException = new RemoteCreator.RemoteCreatorException(new StringBuilder(64).append("Could not get button with size ").append(i2).append(" and color ").append(i3).toString(), e2);
            AppMethodBeat.o(11871);
            throw remoteCreatorException;
        }
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    public final ISignInButtonCreator getRemoteCreator(IBinder iBinder) {
        AppMethodBeat.i(11872);
        ISignInButtonCreator asInterface = ISignInButtonCreator.Stub.asInterface(iBinder);
        AppMethodBeat.o(11872);
        return asInterface;
    }
}
