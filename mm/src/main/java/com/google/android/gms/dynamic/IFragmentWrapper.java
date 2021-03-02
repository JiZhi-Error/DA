package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.google.android.gms.internal.stable.zzc;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.a;

public interface IFragmentWrapper extends IInterface {

    public static abstract class Stub extends zzb implements IFragmentWrapper {
        private byte _hellAccFlag_;

        public static class Proxy extends zza implements IFragmentWrapper {
            Proxy(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.dynamic.IFragmentWrapper");
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public IObjectWrapper getActivity() {
                AppMethodBeat.i(5390);
                Parcel transactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken());
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                AppMethodBeat.o(5390);
                return asInterface;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public Bundle getArguments() {
                AppMethodBeat.i(5391);
                Parcel transactAndReadException = transactAndReadException(3, obtainAndWriteInterfaceToken());
                Bundle bundle = (Bundle) zzc.zza(transactAndReadException, Bundle.CREATOR);
                transactAndReadException.recycle();
                AppMethodBeat.o(5391);
                return bundle;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public int getId() {
                AppMethodBeat.i(5392);
                Parcel transactAndReadException = transactAndReadException(4, obtainAndWriteInterfaceToken());
                int readInt = transactAndReadException.readInt();
                transactAndReadException.recycle();
                AppMethodBeat.o(5392);
                return readInt;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public IFragmentWrapper getParentFragment() {
                AppMethodBeat.i(5393);
                Parcel transactAndReadException = transactAndReadException(5, obtainAndWriteInterfaceToken());
                IFragmentWrapper asInterface = Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                AppMethodBeat.o(5393);
                return asInterface;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public IObjectWrapper getResources() {
                AppMethodBeat.i(5394);
                Parcel transactAndReadException = transactAndReadException(6, obtainAndWriteInterfaceToken());
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                AppMethodBeat.o(5394);
                return asInterface;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public boolean getRetainInstance() {
                AppMethodBeat.i(5395);
                Parcel transactAndReadException = transactAndReadException(7, obtainAndWriteInterfaceToken());
                boolean zza = zzc.zza(transactAndReadException);
                transactAndReadException.recycle();
                AppMethodBeat.o(5395);
                return zza;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public String getTag() {
                AppMethodBeat.i(5396);
                Parcel transactAndReadException = transactAndReadException(8, obtainAndWriteInterfaceToken());
                String readString = transactAndReadException.readString();
                transactAndReadException.recycle();
                AppMethodBeat.o(5396);
                return readString;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public IFragmentWrapper getTargetFragment() {
                AppMethodBeat.i(5397);
                Parcel transactAndReadException = transactAndReadException(9, obtainAndWriteInterfaceToken());
                IFragmentWrapper asInterface = Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                AppMethodBeat.o(5397);
                return asInterface;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public int getTargetRequestCode() {
                AppMethodBeat.i(5398);
                Parcel transactAndReadException = transactAndReadException(10, obtainAndWriteInterfaceToken());
                int readInt = transactAndReadException.readInt();
                transactAndReadException.recycle();
                AppMethodBeat.o(5398);
                return readInt;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public boolean getUserVisibleHint() {
                AppMethodBeat.i(5399);
                Parcel transactAndReadException = transactAndReadException(11, obtainAndWriteInterfaceToken());
                boolean zza = zzc.zza(transactAndReadException);
                transactAndReadException.recycle();
                AppMethodBeat.o(5399);
                return zza;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public IObjectWrapper getView() {
                AppMethodBeat.i(5400);
                Parcel transactAndReadException = transactAndReadException(12, obtainAndWriteInterfaceToken());
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                AppMethodBeat.o(5400);
                return asInterface;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public boolean isAdded() {
                AppMethodBeat.i(5401);
                Parcel transactAndReadException = transactAndReadException(13, obtainAndWriteInterfaceToken());
                boolean zza = zzc.zza(transactAndReadException);
                transactAndReadException.recycle();
                AppMethodBeat.o(5401);
                return zza;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public boolean isDetached() {
                AppMethodBeat.i(5402);
                Parcel transactAndReadException = transactAndReadException(14, obtainAndWriteInterfaceToken());
                boolean zza = zzc.zza(transactAndReadException);
                transactAndReadException.recycle();
                AppMethodBeat.o(5402);
                return zza;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public boolean isHidden() {
                AppMethodBeat.i(5403);
                Parcel transactAndReadException = transactAndReadException(15, obtainAndWriteInterfaceToken());
                boolean zza = zzc.zza(transactAndReadException);
                transactAndReadException.recycle();
                AppMethodBeat.o(5403);
                return zza;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public boolean isInLayout() {
                AppMethodBeat.i(5404);
                Parcel transactAndReadException = transactAndReadException(16, obtainAndWriteInterfaceToken());
                boolean zza = zzc.zza(transactAndReadException);
                transactAndReadException.recycle();
                AppMethodBeat.o(5404);
                return zza;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public boolean isRemoving() {
                AppMethodBeat.i(5405);
                Parcel transactAndReadException = transactAndReadException(17, obtainAndWriteInterfaceToken());
                boolean zza = zzc.zza(transactAndReadException);
                transactAndReadException.recycle();
                AppMethodBeat.o(5405);
                return zza;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public boolean isResumed() {
                AppMethodBeat.i(5406);
                Parcel transactAndReadException = transactAndReadException(18, obtainAndWriteInterfaceToken());
                boolean zza = zzc.zza(transactAndReadException);
                transactAndReadException.recycle();
                AppMethodBeat.o(5406);
                return zza;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public boolean isVisible() {
                AppMethodBeat.i(5407);
                Parcel transactAndReadException = transactAndReadException(19, obtainAndWriteInterfaceToken());
                boolean zza = zzc.zza(transactAndReadException);
                transactAndReadException.recycle();
                AppMethodBeat.o(5407);
                return zza;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public void registerForContextMenu(IObjectWrapper iObjectWrapper) {
                AppMethodBeat.i(5408);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
                transactAndReadExceptionReturnVoid(20, obtainAndWriteInterfaceToken);
                AppMethodBeat.o(5408);
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public void setHasOptionsMenu(boolean z) {
                AppMethodBeat.i(5409);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, z);
                transactAndReadExceptionReturnVoid(21, obtainAndWriteInterfaceToken);
                AppMethodBeat.o(5409);
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public void setMenuVisibility(boolean z) {
                AppMethodBeat.i(5410);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, z);
                transactAndReadExceptionReturnVoid(22, obtainAndWriteInterfaceToken);
                AppMethodBeat.o(5410);
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public void setRetainInstance(boolean z) {
                AppMethodBeat.i(5411);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, z);
                transactAndReadExceptionReturnVoid(23, obtainAndWriteInterfaceToken);
                AppMethodBeat.o(5411);
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public void setUserVisibleHint(boolean z) {
                AppMethodBeat.i(5412);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, z);
                transactAndReadExceptionReturnVoid(24, obtainAndWriteInterfaceToken);
                AppMethodBeat.o(5412);
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public void startActivity(Intent intent) {
                AppMethodBeat.i(5413);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, intent);
                transactAndReadExceptionReturnVoid(25, obtainAndWriteInterfaceToken);
                AppMethodBeat.o(5413);
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public void startActivityForResult(Intent intent, int i2) {
                AppMethodBeat.i(5414);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, intent);
                obtainAndWriteInterfaceToken.writeInt(i2);
                transactAndReadExceptionReturnVoid(26, obtainAndWriteInterfaceToken);
                AppMethodBeat.o(5414);
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public void unregisterForContextMenu(IObjectWrapper iObjectWrapper) {
                AppMethodBeat.i(5415);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
                transactAndReadExceptionReturnVoid(27, obtainAndWriteInterfaceToken);
                AppMethodBeat.o(5415);
            }
        }

        public Stub() {
            super("com.google.android.gms.dynamic.IFragmentWrapper");
        }

        public static IFragmentWrapper asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            return queryLocalInterface instanceof IFragmentWrapper ? (IFragmentWrapper) queryLocalInterface : new Proxy(iBinder);
        }

        @Override // com.google.android.gms.internal.stable.zzb
        public boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) {
            switch (i2) {
                case 2:
                    IObjectWrapper activity = getActivity();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, activity);
                    break;
                case 3:
                    Bundle arguments = getArguments();
                    parcel2.writeNoException();
                    zzc.zzb(parcel2, arguments);
                    break;
                case 4:
                    int id = getId();
                    parcel2.writeNoException();
                    parcel2.writeInt(id);
                    break;
                case 5:
                    IFragmentWrapper parentFragment = getParentFragment();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, parentFragment);
                    break;
                case 6:
                    IObjectWrapper resources = getResources();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, resources);
                    break;
                case 7:
                    boolean retainInstance = getRetainInstance();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, retainInstance);
                    break;
                case 8:
                    String tag = getTag();
                    parcel2.writeNoException();
                    parcel2.writeString(tag);
                    break;
                case 9:
                    IFragmentWrapper targetFragment = getTargetFragment();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, targetFragment);
                    break;
                case 10:
                    int targetRequestCode = getTargetRequestCode();
                    parcel2.writeNoException();
                    parcel2.writeInt(targetRequestCode);
                    break;
                case 11:
                    boolean userVisibleHint = getUserVisibleHint();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, userVisibleHint);
                    break;
                case 12:
                    IObjectWrapper view = getView();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, view);
                    break;
                case 13:
                    boolean isAdded = isAdded();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, isAdded);
                    break;
                case 14:
                    boolean isDetached = isDetached();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, isDetached);
                    break;
                case 15:
                    boolean isHidden = isHidden();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, isHidden);
                    break;
                case 16:
                    boolean isInLayout = isInLayout();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, isInLayout);
                    break;
                case 17:
                    boolean isRemoving = isRemoving();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, isRemoving);
                    break;
                case 18:
                    boolean isResumed = isResumed();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, isResumed);
                    break;
                case 19:
                    boolean isVisible = isVisible();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, isVisible);
                    break;
                case 20:
                    registerForContextMenu(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    break;
                case 21:
                    setHasOptionsMenu(zzc.zza(parcel));
                    parcel2.writeNoException();
                    break;
                case 22:
                    setMenuVisibility(zzc.zza(parcel));
                    parcel2.writeNoException();
                    break;
                case 23:
                    setRetainInstance(zzc.zza(parcel));
                    parcel2.writeNoException();
                    break;
                case 24:
                    setUserVisibleHint(zzc.zza(parcel));
                    parcel2.writeNoException();
                    break;
                case 25:
                    a bl = new a().bl((Intent) zzc.zza(parcel, Intent.CREATOR));
                    com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/google/android/gms/dynamic/IFragmentWrapper$Stub", "dispatchTransaction", "(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/google/android/gms/dynamic/IFragmentWrapper$Stub", "dispatchTransaction", "(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    parcel2.writeNoException();
                    break;
                case 26:
                    startActivityForResult((Intent) zzc.zza(parcel, Intent.CREATOR), parcel.readInt());
                    parcel2.writeNoException();
                    break;
                case 27:
                    unregisterForContextMenu(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    break;
                default:
                    return false;
            }
            return true;
        }
    }

    IObjectWrapper getActivity();

    Bundle getArguments();

    int getId();

    IFragmentWrapper getParentFragment();

    IObjectWrapper getResources();

    boolean getRetainInstance();

    String getTag();

    IFragmentWrapper getTargetFragment();

    int getTargetRequestCode();

    boolean getUserVisibleHint();

    IObjectWrapper getView();

    boolean isAdded();

    boolean isDetached();

    boolean isHidden();

    boolean isInLayout();

    boolean isRemoving();

    boolean isResumed();

    boolean isVisible();

    void registerForContextMenu(IObjectWrapper iObjectWrapper);

    void setHasOptionsMenu(boolean z);

    void setMenuVisibility(boolean z);

    void setRetainInstance(boolean z);

    void setUserVisibleHint(boolean z);

    void startActivity(Intent intent);

    void startActivityForResult(Intent intent, int i2);

    void unregisterForContextMenu(IObjectWrapper iObjectWrapper);
}
