package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import io.flutter.embedding.android.c;
import io.flutter.embedding.engine.d;
import io.flutter.view.FlutterMain;

public class FlutterFragment extends Fragment implements c.a {
    c SMA;

    @Override // io.flutter.embedding.android.c.a, android.support.v4.app.Fragment
    public final /* bridge */ /* synthetic */ Activity getActivity() {
        AppMethodBeat.i(10111);
        FragmentActivity activity = super.getActivity();
        AppMethodBeat.o(10111);
        return activity;
    }

    public static b hwr() {
        AppMethodBeat.i(215016);
        b bVar = new b();
        AppMethodBeat.o(215016);
        return bVar;
    }

    public static class b {
        private final Class<? extends FlutterFragment> SMI = FlutterFragment.class;
        i SML = i.surface;
        l SMM = l.transparent;
        boolean SMN = true;
        String SMO = null;
        d SMP = null;
        String SxI = "main";
        String SxJ = FilePathGenerator.ANDROID_DIR_SEP;

        public final <T extends FlutterFragment> T hws() {
            AppMethodBeat.i(215100);
            try {
                T t = (T) ((FlutterFragment) this.SMI.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                if (t == null) {
                    RuntimeException runtimeException = new RuntimeException("The FlutterFragment subclass sent in the constructor (" + this.SMI.getCanonicalName() + ") does not match the expected return type.");
                    AppMethodBeat.o(215100);
                    throw runtimeException;
                }
                Bundle bundle = new Bundle();
                bundle.putString("initial_route", this.SxJ);
                bundle.putString("app_bundle_path", this.SMO);
                bundle.putString("dart_entrypoint", this.SxI);
                if (this.SMP != null) {
                    bundle.putStringArray("initialization_args", this.SMP.toArray());
                }
                bundle.putString("flutterview_render_mode", this.SML != null ? this.SML.name() : i.surface.name());
                bundle.putString("flutterview_transparency_mode", this.SMM != null ? this.SMM.name() : l.transparent.name());
                bundle.putBoolean("should_attach_engine_to_activity", this.SMN);
                bundle.putBoolean("destroy_engine_with_fragment", true);
                t.setArguments(bundle);
                AppMethodBeat.o(215100);
                return t;
            } catch (Exception e2) {
                RuntimeException runtimeException2 = new RuntimeException("Could not instantiate FlutterFragment subclass (" + this.SMI.getName() + ")", e2);
                AppMethodBeat.o(215100);
                throw runtimeException2;
            }
        }
    }

    public static a bsZ(String str) {
        AppMethodBeat.i(215017);
        a aVar = new a(str, (byte) 0);
        AppMethodBeat.o(215017);
        return aVar;
    }

    public static class a {
        private final Class<? extends FlutterFragment> SMI;
        private final String SMJ;
        boolean SMK;
        i SML;
        l SMM;
        boolean SMN;

        /* synthetic */ a(String str, byte b2) {
            this(str);
        }

        private a(String str) {
            this(FlutterFragment.class, str);
        }

        private a(Class<? extends FlutterFragment> cls, String str) {
            this.SMK = false;
            this.SML = i.surface;
            this.SMM = l.transparent;
            this.SMN = true;
            this.SMI = cls;
            this.SMJ = str;
        }

        public final <T extends FlutterFragment> T hws() {
            AppMethodBeat.i(215095);
            try {
                T t = (T) ((FlutterFragment) this.SMI.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                if (t == null) {
                    RuntimeException runtimeException = new RuntimeException("The FlutterFragment subclass sent in the constructor (" + this.SMI.getCanonicalName() + ") does not match the expected return type.");
                    AppMethodBeat.o(215095);
                    throw runtimeException;
                }
                Bundle bundle = new Bundle();
                bundle.putString("cached_engine_id", this.SMJ);
                bundle.putBoolean("destroy_engine_with_fragment", this.SMK);
                bundle.putString("flutterview_render_mode", this.SML != null ? this.SML.name() : i.surface.name());
                bundle.putString("flutterview_transparency_mode", this.SMM != null ? this.SMM.name() : l.transparent.name());
                bundle.putBoolean("should_attach_engine_to_activity", this.SMN);
                t.setArguments(bundle);
                AppMethodBeat.o(215095);
                return t;
            } catch (Exception e2) {
                RuntimeException runtimeException2 = new RuntimeException("Could not instantiate FlutterFragment subclass (" + this.SMI.getName() + ")", e2);
                AppMethodBeat.o(215095);
                throw runtimeException2;
            }
        }
    }

    public FlutterFragment() {
        AppMethodBeat.i(10085);
        setArguments(new Bundle());
        AppMethodBeat.o(10085);
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        AppMethodBeat.i(10086);
        super.onAttach(context);
        this.SMA = new c(this);
        this.SMA.hrO();
        AppMethodBeat.o(10086);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppMethodBeat.i(10087);
        View hrQ = this.SMA.hrQ();
        AppMethodBeat.o(10087);
        return hrQ;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        AppMethodBeat.i(215018);
        super.onActivityCreated(bundle);
        this.SMA.onActivityCreated(bundle);
        AppMethodBeat.o(215018);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        AppMethodBeat.i(10088);
        super.onStart();
        this.SMA.onStart();
        AppMethodBeat.o(10088);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        AppMethodBeat.i(10089);
        super.onResume();
        this.SMA.onResume();
        AppMethodBeat.o(10089);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        AppMethodBeat.i(10090);
        super.onPause();
        this.SMA.onPause();
        AppMethodBeat.o(10090);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        AppMethodBeat.i(10091);
        super.onStop();
        this.SMA.onStop();
        AppMethodBeat.o(10091);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        AppMethodBeat.i(10092);
        super.onDestroyView();
        this.SMA.onDestroyView();
        AppMethodBeat.o(10092);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.i(215019);
        super.onSaveInstanceState(bundle);
        this.SMA.onSaveInstanceState(bundle);
        AppMethodBeat.o(215019);
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        AppMethodBeat.i(10093);
        super.onDetach();
        this.SMA.onDetach();
        c cVar = this.SMA;
        cVar.SMB = null;
        cVar.wJi = null;
        cVar.wKM = null;
        cVar.wKN = null;
        this.SMA = null;
        AppMethodBeat.o(10093);
    }

    @Override // android.support.v4.app.Fragment
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(10094);
        this.SMA.onRequestPermissionsResult(i2, strArr, iArr);
        AppMethodBeat.o(10094);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(10095);
        this.SMA.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(10095);
    }

    @Override // android.support.v4.app.Fragment
    public void onLowMemory() {
        AppMethodBeat.i(10096);
        super.onLowMemory();
        c cVar = this.SMA;
        io.flutter.a.hwd();
        cVar.hrS();
        cVar.wJi.SNW.notifyLowMemoryWarning();
        cVar.wJi.SOh.hxj();
        AppMethodBeat.o(10096);
    }

    @Override // io.flutter.embedding.android.c.a
    public final d hwl() {
        AppMethodBeat.i(10097);
        String[] stringArray = getArguments().getStringArray("initialization_args");
        if (stringArray == null) {
            stringArray = new String[0];
        }
        d dVar = new d(stringArray);
        AppMethodBeat.o(10097);
        return dVar;
    }

    @Override // io.flutter.embedding.android.c.a
    public final String KJ() {
        AppMethodBeat.i(10098);
        String string = getArguments().getString("cached_engine_id", null);
        AppMethodBeat.o(10098);
        return string;
    }

    @Override // io.flutter.embedding.android.c.a
    public final boolean hwm() {
        AppMethodBeat.i(10099);
        boolean z = getArguments().getBoolean("destroy_engine_with_fragment", false);
        if (KJ() != null || this.SMA.Syd) {
            AppMethodBeat.o(10099);
            return z;
        }
        boolean z2 = getArguments().getBoolean("destroy_engine_with_fragment", true);
        AppMethodBeat.o(10099);
        return z2;
    }

    @Override // io.flutter.embedding.android.c.a
    public final String KK() {
        AppMethodBeat.i(10100);
        String string = getArguments().getString("dart_entrypoint", "main");
        AppMethodBeat.o(10100);
        return string;
    }

    @Override // io.flutter.embedding.android.c.a
    public final String KL() {
        AppMethodBeat.i(10101);
        String string = getArguments().getString("app_bundle_path", FlutterMain.findAppBundlePath());
        AppMethodBeat.o(10101);
        return string;
    }

    @Override // io.flutter.embedding.android.c.a
    public final String KM() {
        AppMethodBeat.i(10102);
        String string = getArguments().getString("initial_route");
        AppMethodBeat.o(10102);
        return string;
    }

    @Override // io.flutter.embedding.android.c.a
    public final i hwn() {
        AppMethodBeat.i(215020);
        i valueOf = i.valueOf(getArguments().getString("flutterview_render_mode", i.surface.name()));
        AppMethodBeat.o(215020);
        return valueOf;
    }

    @Override // io.flutter.embedding.android.c.a
    public final l hwo() {
        AppMethodBeat.i(215021);
        l valueOf = l.valueOf(getArguments().getString("flutterview_transparency_mode", l.transparent.name()));
        AppMethodBeat.o(215021);
        return valueOf;
    }

    @Override // io.flutter.embedding.android.c.a, io.flutter.embedding.android.k
    public final j KF() {
        AppMethodBeat.i(10105);
        FragmentActivity activity = getActivity();
        if (activity instanceof k) {
            j KF = ((k) activity).KF();
            AppMethodBeat.o(10105);
            return KF;
        }
        AppMethodBeat.o(10105);
        return null;
    }

    @Override // io.flutter.embedding.android.f, io.flutter.embedding.android.c.a
    public final io.flutter.embedding.engine.a KP() {
        io.flutter.embedding.engine.a aVar;
        AppMethodBeat.i(10106);
        FragmentActivity activity = getActivity();
        if (activity instanceof f) {
            io.flutter.a.hwd();
            getContext();
            aVar = ((f) activity).KP();
        } else {
            aVar = null;
        }
        AppMethodBeat.o(10106);
        return aVar;
    }

    @Override // io.flutter.embedding.android.c.a
    public final io.flutter.plugin.platform.b a(Activity activity, io.flutter.embedding.engine.a aVar) {
        AppMethodBeat.i(10107);
        if (activity != null) {
            io.flutter.plugin.platform.b bVar = new io.flutter.plugin.platform.b(getActivity(), aVar.SOe);
            AppMethodBeat.o(10107);
            return bVar;
        }
        AppMethodBeat.o(10107);
        return null;
    }

    @Override // io.flutter.embedding.android.e, io.flutter.embedding.android.c.a
    public final void b(io.flutter.embedding.engine.a aVar) {
        AppMethodBeat.i(10108);
        FragmentActivity activity = getActivity();
        if (activity instanceof e) {
            ((e) activity).b(aVar);
        }
        AppMethodBeat.o(10108);
    }

    @Override // io.flutter.embedding.android.e, io.flutter.embedding.android.c.a
    public final void c(io.flutter.embedding.engine.a aVar) {
        AppMethodBeat.i(215022);
        FragmentActivity activity = getActivity();
        if (activity instanceof e) {
            ((e) activity).c(aVar);
        }
        AppMethodBeat.o(215022);
    }

    @Override // io.flutter.embedding.android.c.a
    public final boolean hwp() {
        AppMethodBeat.i(10109);
        boolean z = getArguments().getBoolean("should_attach_engine_to_activity");
        AppMethodBeat.o(10109);
        return z;
    }

    @Override // io.flutter.embedding.android.c.a
    public final void dLt() {
        AppMethodBeat.i(215023);
        FragmentActivity activity = getActivity();
        if (activity instanceof io.flutter.embedding.engine.b.b) {
            ((io.flutter.embedding.engine.b.b) activity).dLt();
        }
        AppMethodBeat.o(215023);
    }

    @Override // io.flutter.embedding.android.c.a
    public final void dLu() {
        AppMethodBeat.i(215024);
        FragmentActivity activity = getActivity();
        if (activity instanceof io.flutter.embedding.engine.b.b) {
            ((io.flutter.embedding.engine.b.b) activity).dLu();
        }
        AppMethodBeat.o(215024);
    }

    @Override // io.flutter.embedding.android.c.a
    public final boolean hwq() {
        AppMethodBeat.i(215025);
        if (getArguments().containsKey("enable_state_restoration")) {
            boolean z = getArguments().getBoolean("enable_state_restoration");
            AppMethodBeat.o(215025);
            return z;
        } else if (KJ() != null) {
            AppMethodBeat.o(215025);
            return false;
        } else {
            AppMethodBeat.o(215025);
            return true;
        }
    }
}
