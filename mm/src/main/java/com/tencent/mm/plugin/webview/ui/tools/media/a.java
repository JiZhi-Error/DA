package com.tencent.mm.plugin.webview.ui.tools.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004J\u0016\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012XD¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/media/KV18589Report;", "", "()V", "OP_CANCEL", "", "OP_FAV", "OP_SEND_TO_FRIEND", "OP_SNS", "SCENE_CHAT", "SCENE_FAV", "SCENE_MP", "SCENE_SNS", "SHOW_MENU_FROM_JSAPI", "SHOW_MENU_FROM_JSAPI_SHARE", "SHOW_MENU_FROM_LONG_PRESS", "SHOW_MENU_FROM_MORE", "SHOW_MENU_FROM_SHARE", "TAG", "", "reportMenuClick", "", "opType", "from", "scene", "reportShowMenu", "plugin-webview_release"})
public final class a {
    public static final a JvG = new a();
    private static final String TAG = TAG;

    static {
        AppMethodBeat.i(82580);
        AppMethodBeat.o(82580);
    }

    private a() {
    }

    public static void kr(int i2, int i3) {
        int i4 = 2;
        AppMethodBeat.i(82578);
        h hVar = h.INSTANCE;
        Object[] objArr = new Object[2];
        switch (i2) {
            case 1:
                i4 = 10;
                break;
            case 2:
            default:
                i4 = 6;
                break;
            case 3:
                break;
        }
        objArr[0] = Integer.valueOf(i4);
        objArr[1] = Integer.valueOf(i3);
        hVar.a(18589, objArr);
        AppMethodBeat.o(82578);
    }

    public static void aN(int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        AppMethodBeat.i(82579);
        switch (i2) {
            case 1:
                h hVar = h.INSTANCE;
                Object[] objArr = new Object[2];
                switch (i3) {
                    case 1:
                        i7 = 11;
                        break;
                    case 2:
                        i7 = 23;
                        break;
                    case 3:
                        i7 = 3;
                        break;
                    case 4:
                    default:
                        i7 = 7;
                        break;
                    case 5:
                        i7 = 19;
                        break;
                }
                objArr[0] = Integer.valueOf(i7);
                objArr[1] = Integer.valueOf(i4);
                hVar.a(18589, objArr);
                AppMethodBeat.o(82579);
                return;
            case 2:
                h hVar2 = h.INSTANCE;
                Object[] objArr2 = new Object[2];
                switch (i3) {
                    case 1:
                        i6 = 12;
                        break;
                    case 2:
                    default:
                        i6 = 8;
                        break;
                    case 3:
                        i6 = 4;
                        break;
                }
                objArr2[0] = Integer.valueOf(i6);
                objArr2[1] = Integer.valueOf(i4);
                hVar2.a(18589, objArr2);
                AppMethodBeat.o(82579);
                return;
            case 3:
            default:
                h hVar3 = h.INSTANCE;
                Object[] objArr3 = new Object[2];
                switch (i3) {
                    case 1:
                        i8 = 13;
                        break;
                    case 2:
                        i8 = 25;
                        break;
                    case 3:
                        i8 = 5;
                        break;
                    case 4:
                    default:
                        i8 = 9;
                        break;
                    case 5:
                        i8 = 21;
                        break;
                }
                objArr3[0] = Integer.valueOf(i8);
                objArr3[1] = Integer.valueOf(i4);
                hVar3.a(18589, objArr3);
                AppMethodBeat.o(82579);
                return;
            case 4:
                h hVar4 = h.INSTANCE;
                Object[] objArr4 = new Object[2];
                switch (i3) {
                    case 1:
                        i5 = 22;
                        break;
                    case 2:
                        i5 = 24;
                        break;
                    case 3:
                        i5 = 17;
                        break;
                    case 4:
                    default:
                        i5 = 18;
                        break;
                    case 5:
                        i5 = 20;
                        break;
                }
                objArr4[0] = Integer.valueOf(i5);
                objArr4[1] = Integer.valueOf(i4);
                hVar4.a(18589, objArr4);
                AppMethodBeat.o(82579);
                return;
        }
    }
}
