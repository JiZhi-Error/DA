package com.github.a.a;

import android.app.Activity;
import android.view.OrientationEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.a.d;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k;
import java.util.List;

public final class a implements k.c {
    Activity activity;
    k bbv;
    d bbw;
    OrientationEventListener bbx;
    int bby = -1;

    @Override // io.flutter.plugin.a.k.c
    public final void a(j jVar, k.d dVar) {
        AppMethodBeat.i(199077);
        if (this.activity == null) {
            dVar.b("NO_ACTIVITY", "OrientationPlugin requires a foreground activity.", null);
            AppMethodBeat.o(199077);
            return;
        }
        String str = jVar.method;
        Object obj = jVar.SxX;
        if (str.equals("SystemChrome.setEnabledSystemUIOverlays")) {
            List list = (List) obj;
            int i2 = 7942;
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (list.get(i3).equals("SystemUiOverlay.top")) {
                    i2 &= -5;
                } else if (list.get(i3).equals("SystemUiOverlay.bottom")) {
                    i2 &= -3;
                }
            }
            this.activity.getWindow().getDecorView().setSystemUiVisibility(i2);
            dVar.ba(null);
            AppMethodBeat.o(199077);
        } else if (str.equals("SystemChrome.setPreferredOrientations")) {
            List list2 = (List) obj;
            boolean z = false;
            for (int i4 = 0; i4 < list2.size(); i4++) {
                if (list2.get(i4).equals("DeviceOrientation.portraitUp")) {
                    z |= true;
                } else if (list2.get(i4).equals("DeviceOrientation.landscapeLeft")) {
                    z |= true;
                } else if (list2.get(i4).equals("DeviceOrientation.portraitDown")) {
                    z |= true;
                } else if (list2.get(i4).equals("DeviceOrientation.landscapeRight")) {
                    z |= true;
                }
            }
            switch (z) {
                case false:
                    this.activity.setRequestedOrientation(-1);
                    break;
                case true:
                    this.activity.setRequestedOrientation(1);
                    break;
                case true:
                    this.activity.setRequestedOrientation(0);
                    break;
                case true:
                case true:
                case true:
                case true:
                case true:
                case true:
                case true:
                    this.activity.setRequestedOrientation(13);
                    break;
                case true:
                    this.activity.setRequestedOrientation(9);
                    break;
                case true:
                    this.activity.setRequestedOrientation(12);
                    break;
                case true:
                    this.activity.setRequestedOrientation(8);
                    break;
                case true:
                    this.activity.setRequestedOrientation(11);
                    break;
                case true:
                    this.activity.setRequestedOrientation(2);
                    break;
                case true:
                    this.activity.setRequestedOrientation(13);
                    break;
            }
            dVar.ba(null);
            AppMethodBeat.o(199077);
        } else if (str.equals("SystemChrome.forceOrientation")) {
            String str2 = (String) obj;
            if (str2.equals("DeviceOrientation.portraitUp")) {
                this.activity.setRequestedOrientation(1);
            } else if (str2.equals("DeviceOrientation.portraitDown")) {
                this.activity.setRequestedOrientation(9);
            } else if (str2.equals("DeviceOrientation.landscapeLeft")) {
                this.activity.setRequestedOrientation(8);
            } else if (str2.equals("DeviceOrientation.landscapeRight")) {
                this.activity.setRequestedOrientation(0);
            } else {
                this.activity.setRequestedOrientation(-1);
            }
            dVar.ba(null);
            AppMethodBeat.o(199077);
        } else {
            dVar.dLv();
            AppMethodBeat.o(199077);
        }
    }
}
