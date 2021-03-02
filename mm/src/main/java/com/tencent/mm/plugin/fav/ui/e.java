package com.tencent.mm.plugin.fav.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.b.f;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.kernel.g;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LongBitmapHandler;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.snackbar.a;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import java.util.Map;

public class e {
    private static Map<String, Integer> oYD;
    private static f<String, Bitmap> tdM = new b(20, e.class);

    public static void a(int i2, Activity activity, a.b bVar) {
        AppMethodBeat.i(106676);
        a(i2, activity, null, null, bVar);
        AppMethodBeat.o(106676);
    }

    public static void a(int i2, Activity activity, a.c cVar, DialogInterface.OnClickListener onClickListener, a.b bVar) {
        AppMethodBeat.i(235281);
        a(-1, i2, activity, null, cVar, onClickListener, bVar, true);
        AppMethodBeat.o(235281);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void a(int i2, int i3, Activity activity, Fragment fragment, a.c cVar, final DialogInterface.OnClickListener onClickListener, a.b bVar, boolean z) {
        a.b bVar2;
        FragmentActivity fragmentActivity;
        String string;
        AppMethodBeat.i(235282);
        if (activity == null && fragment == null) {
            Log.e("MicroMsg.FavExportLogic", "handleErrorType activity = null && fragment = null");
            AppMethodBeat.o(235282);
            return;
        }
        if (bVar == null) {
            bVar2 = new a.b() {
                /* class com.tencent.mm.plugin.fav.ui.e.AnonymousClass1 */

                @Override // com.tencent.mm.ui.widget.snackbar.a.b
                public final void bDZ() {
                    AppMethodBeat.i(106670);
                    hb hbVar = new hb();
                    hbVar.dLm.type = 35;
                    EventCenter.instance.publish(hbVar);
                    AppMethodBeat.o(106670);
                }
            };
        } else {
            bVar2 = bVar;
        }
        if (i3 != 0) {
            if (activity == null) {
                fragmentActivity = fragment.getActivity();
            } else {
                fragmentActivity = activity;
            }
            switch (i3) {
                case -10:
                    a(fragmentActivity, fragment);
                    AppMethodBeat.o(235282);
                    return;
                case -9:
                case -8:
                case -7:
                case -6:
                case -5:
                case -4:
                    a(i2, i3, fragmentActivity, fragment, onClickListener, bVar2, cVar);
                    AppMethodBeat.o(235282);
                    return;
                case -3:
                default:
                    if (i3 != R.string.ccw) {
                        string = fragmentActivity.getString(R.string.ccv);
                    } else if (i2 == 2) {
                        string = fragmentActivity.getString(R.string.ccw, new Object[]{Integer.valueOf(((af) g.ah(af.class)).getImageSizeLimitInMB(true))});
                    } else if (i2 == 4 || i2 == 16) {
                        string = fragmentActivity.getString(R.string.ccw, new Object[]{Integer.valueOf(((af) g.ah(af.class)).getVideoSizeLimitInMB(true))});
                    } else {
                        string = fragmentActivity.getString(R.string.ccw, new Object[]{Integer.valueOf(((af) g.ah(af.class)).getFileSizeLimitInMB(true))});
                    }
                    h.d(fragmentActivity, string, "", new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.fav.ui.e.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(106671);
                            if (onClickListener != null) {
                                onClickListener.onClick(dialogInterface, -1);
                            }
                            AppMethodBeat.o(106671);
                        }
                    });
                    break;
                case -2:
                    f(fragmentActivity, onClickListener);
                    AppMethodBeat.o(235282);
                    return;
            }
        } else if (z) {
            if (fragment != null) {
                View view = fragment.getView();
                if (fragment instanceof MMFragment) {
                    view = ((MMFragment) fragment).getContentView();
                }
                com.tencent.mm.ui.widget.snackbar.b.a(fragment.getContext(), view, fragment.getString(R.string.caf), fragment.getString(R.string.c90), bVar2, cVar);
                AppMethodBeat.o(235282);
                return;
            } else if (activity != null) {
                com.tencent.mm.ui.widget.snackbar.b.a(activity, activity.getString(R.string.caf), activity.getString(R.string.c90), bVar2, cVar);
                AppMethodBeat.o(235282);
                return;
            }
        }
        AppMethodBeat.o(235282);
    }

    private static void a(Activity activity, Fragment fragment) {
        AppMethodBeat.i(106678);
        if (fragment != null) {
            activity = fragment.getActivity();
        }
        u.makeText(activity, (int) R.string.c_a, 0).show();
        AppMethodBeat.o(106678);
    }

    private static void f(final Context context, final DialogInterface.OnClickListener onClickListener) {
        AppMethodBeat.i(106679);
        h.a(context, context.getString(R.string.c_4), context.getString(R.string.c_5), context.getString(R.string.c_7), context.getString(R.string.b96), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.fav.ui.e.AnonymousClass3 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(106672);
                Intent intent = new Intent();
                intent.putExtra("key_enter_fav_cleanui_from", 3);
                com.tencent.mm.plugin.fav.a.b.b(context, ".ui.FavCleanUI", intent);
                dialogInterface.dismiss();
                if (onClickListener != null) {
                    onClickListener.onClick(dialogInterface, -2);
                }
                AppMethodBeat.o(106672);
            }
        }, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.fav.ui.e.AnonymousClass4 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(106673);
                dialogInterface.dismiss();
                if (onClickListener != null) {
                    onClickListener.onClick(dialogInterface, -1);
                }
                AppMethodBeat.o(106673);
            }
        }, (int) R.color.afp);
        AppMethodBeat.o(106679);
    }

    private static void a(int i2, int i3, final Activity activity, final Fragment fragment, final DialogInterface.OnClickListener onClickListener, final a.b bVar, final a.c cVar) {
        FragmentActivity activity2;
        String string;
        AppMethodBeat.i(106680);
        if (fragment == null) {
            activity2 = activity;
        } else {
            activity2 = fragment.getActivity();
        }
        if (i3 == -4) {
            switch (i2) {
                case 2:
                    string = activity2.getString(R.string.c9z);
                    break;
                case 4:
                case 16:
                    string = activity2.getString(R.string.c_0);
                    break;
                case 8:
                    string = activity2.getString(R.string.c9y);
                    break;
                case 14:
                    string = activity2.getString(R.string.c_d);
                    break;
                default:
                    string = "";
                    break;
            }
        } else if (i3 == -5) {
            if (i2 == 14) {
                string = activity2.getString(R.string.c_c);
            } else if (i2 == 2) {
                string = activity2.getString(R.string.c91, Integer.valueOf(((af) g.ah(af.class)).getImageSizeLimitInMB(true)));
            } else if (i2 == 4) {
                string = activity2.getString(R.string.c91, Integer.valueOf(((af) g.ah(af.class)).getVideoSizeLimitInMB(true)));
            } else {
                string = activity2.getString(R.string.c91, Integer.valueOf(((af) g.ah(af.class)).getFileSizeLimitInMB(true)));
            }
        } else if (i3 == -6) {
            string = activity2.getString(R.string.c_d);
        } else if (i3 == -7) {
            string = activity2.getString(R.string.c_c);
        } else if (i3 == -8) {
            string = activity2.getString(R.string.c_e);
        } else if (i3 != -9) {
            string = activity2.getString(R.string.c_2);
        } else if (fragment != null) {
            View view = fragment.getView();
            if (fragment instanceof MMFragment) {
                view = ((MMFragment) fragment).getContentView();
            }
            com.tencent.mm.ui.widget.snackbar.b.a(fragment.getContext(), view, activity2.getString(R.string.caf), activity2.getString(R.string.c90), bVar, cVar);
            AppMethodBeat.o(106680);
            return;
        } else {
            com.tencent.mm.ui.widget.snackbar.b.a(activity, activity2.getString(R.string.caf), activity2.getString(R.string.c90), bVar, cVar);
            AppMethodBeat.o(106680);
            return;
        }
        h.a(activity2, string, "", activity2.getString(R.string.fn9), activity2.getString(R.string.b96), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.fav.ui.e.AnonymousClass5 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(106674);
                dialogInterface.dismiss();
                if (onClickListener != null) {
                    onClickListener.onClick(dialogInterface, -2);
                }
                if (fragment != null) {
                    View view = fragment.getView();
                    if (fragment instanceof MMFragment) {
                        view = ((MMFragment) fragment).getContentView();
                    }
                    com.tencent.mm.ui.widget.snackbar.b.a(fragment.getContext(), view, fragment.getActivity().getString(R.string.caf), fragment.getActivity().getString(R.string.c90), bVar, cVar);
                    AppMethodBeat.o(106674);
                    return;
                }
                com.tencent.mm.ui.widget.snackbar.b.a(activity, activity.getString(R.string.caf), activity.getString(R.string.c90), bVar, cVar);
                AppMethodBeat.o(106674);
            }
        }, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.fav.ui.e.AnonymousClass6 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(106675);
                dialogInterface.dismiss();
                if (onClickListener != null) {
                    onClickListener.onClick(dialogInterface, -1);
                }
                AppMethodBeat.o(106675);
            }
        }, (int) R.color.afp);
        AppMethodBeat.o(106680);
    }

    /* JADX WARNING: Removed duplicated region for block: B:72:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x019a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(com.tencent.mm.storage.ca r13, com.tencent.mm.g.a.cz r14, boolean r15) {
        /*
        // Method dump skipped, instructions count: 501
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fav.ui.e.a(com.tencent.mm.storage.ca, com.tencent.mm.g.a.cz, boolean):int");
    }

    private static int a(cz czVar, int i2) {
        AppMethodBeat.i(106682);
        if (czVar.dFZ.dGb.ppH != null && czVar.dFZ.dGb.ppH.size() > 0) {
            aml last = czVar.dFZ.dGb.ppH.getLast();
            if (i2 <= 0) {
                switch (i2) {
                    case -5:
                        last.ajf(2);
                        last.bgt(null);
                        break;
                    case -4:
                        last.ajf(1);
                        last.bgt(null);
                        break;
                    default:
                        last.ajf(0);
                        break;
                }
            }
        }
        b(czVar, i2);
        AppMethodBeat.o(106682);
        return i2;
    }

    private static int a(cz czVar, aml aml, int i2) {
        AppMethodBeat.i(106683);
        if (aml == null) {
            int a2 = a(czVar, i2);
            AppMethodBeat.o(106683);
            return a2;
        }
        if (i2 <= 0) {
            switch (i2) {
                case -5:
                    aml.ajf(2);
                    aml.bgt(null);
                    break;
                case -4:
                    aml.ajf(1);
                    aml.bgt(null);
                    break;
                default:
                    aml.ajf(0);
                    break;
            }
        }
        b(czVar, i2);
        AppMethodBeat.o(106683);
        return i2;
    }

    private static boolean a(ca caVar, cz czVar, String str, boolean z, boolean z2, int i2) {
        k.b bVar;
        AppMethodBeat.i(106684);
        if (!Util.isNullOrNil(str)) {
            o oVar = new o(str);
            if (oVar.exists()) {
                if (oVar.length() > ((long) ((af) g.ah(af.class)).getFavSizeLimit(z2, i2))) {
                    Log.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  file is big");
                    AppMethodBeat.o(106684);
                    return true;
                }
                Log.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  file not big");
            } else if (!z) {
                Log.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  not download finish ！attachFile.exists()");
                czVar.dFZ.dGb.ppH.getLast().bgt(null);
            }
        }
        String str2 = caVar.field_content;
        if (str2 != null) {
            bVar = k.b.aD(str2, caVar.field_reserved);
        } else {
            bVar = null;
        }
        if (bVar != null) {
            if (bVar.iwI > ((af) g.ah(af.class)).getFavSizeLimit(z2, i2)) {
                Log.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  file is big");
                AppMethodBeat.o(106684);
                return true;
            } else if (!Util.isNullOrNil(str) && s.YS(str) && !z) {
                if (((long) bVar.iwI) > s.boW(str)) {
                    Log.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  not download finish content.attachlen > datasize");
                    czVar.dFZ.dGb.ppH.getLast().bgt(null);
                }
            }
        }
        if (str2 == null || bVar == null) {
            Log.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  (xml == null ) ||(content == null)");
        }
        AppMethodBeat.o(106684);
        return false;
    }

    private static void b(cz czVar, int i2) {
        AppMethodBeat.i(106685);
        if (czVar.dFZ.dGb.ppH == null || czVar.dFZ.dGb.ppH.size() == 0) {
            czVar.dFZ.dGe = i2;
            AppMethodBeat.o(106685);
        } else if (czVar.dFZ.dGe == -9) {
            AppMethodBeat.o(106685);
        } else {
            char c2 = (i2 > 0 || czVar.dFZ.dGe > 0) ? (char) 1 : 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < czVar.dFZ.dGb.ppH.size(); i6++) {
                switch (czVar.dFZ.dGb.ppH.get(i6).Lwv) {
                    case 0:
                        i5++;
                        break;
                    case 1:
                        i3++;
                        break;
                    case 2:
                        i4++;
                        break;
                }
            }
            if (c2 > 0) {
                if (i4 > 0 || i3 > 0) {
                    czVar.dFZ.dGe = -9;
                    AppMethodBeat.o(106685);
                    return;
                }
                czVar.dFZ.dGe = i2;
                AppMethodBeat.o(106685);
            } else if (i4 <= 0) {
                if (i3 > 0) {
                    if (i5 == 0) {
                        czVar.dFZ.dGe = -4;
                        AppMethodBeat.o(106685);
                        return;
                    } else if (i5 > 0) {
                        czVar.dFZ.dGe = -6;
                        AppMethodBeat.o(106685);
                        return;
                    }
                }
                AppMethodBeat.o(106685);
            } else if (i3 > 0) {
                czVar.dFZ.dGe = -8;
                AppMethodBeat.o(106685);
            } else if (i5 == 0) {
                czVar.dFZ.dGe = -5;
                AppMethodBeat.o(106685);
            } else if (i5 > 0) {
                czVar.dFZ.dGe = -7;
                AppMethodBeat.o(106685);
            } else {
                AppMethodBeat.o(106685);
            }
        }
    }

    public static void cVI() {
        AppMethodBeat.i(106686);
        tdM = new b(20, e.class);
        AppMethodBeat.o(106686);
    }

    static {
        AppMethodBeat.i(106690);
        oYD = new HashMap();
        HashMap hashMap = new HashMap();
        oYD = hashMap;
        hashMap.put("avi", Integer.valueOf((int) R.raw.app_attach_file_icon_video));
        oYD.put("m4v", Integer.valueOf((int) R.raw.app_attach_file_icon_video));
        oYD.put("vob", Integer.valueOf((int) R.raw.app_attach_file_icon_video));
        oYD.put("mpeg", Integer.valueOf((int) R.raw.app_attach_file_icon_video));
        oYD.put("mpe", Integer.valueOf((int) R.raw.app_attach_file_icon_video));
        oYD.put("asx", Integer.valueOf((int) R.raw.app_attach_file_icon_video));
        oYD.put("asf", Integer.valueOf((int) R.raw.app_attach_file_icon_video));
        oYD.put("f4v", Integer.valueOf((int) R.raw.app_attach_file_icon_video));
        oYD.put("flv", Integer.valueOf((int) R.raw.app_attach_file_icon_video));
        oYD.put("mkv", Integer.valueOf((int) R.raw.app_attach_file_icon_video));
        oYD.put("wmv", Integer.valueOf((int) R.raw.app_attach_file_icon_video));
        oYD.put("wm", Integer.valueOf((int) R.raw.app_attach_file_icon_video));
        oYD.put("3gp", Integer.valueOf((int) R.raw.app_attach_file_icon_video));
        oYD.put("mp4", Integer.valueOf((int) R.raw.app_attach_file_icon_video));
        oYD.put("rmvb", Integer.valueOf((int) R.raw.app_attach_file_icon_video));
        oYD.put("rm", Integer.valueOf((int) R.raw.app_attach_file_icon_video));
        oYD.put("ra", Integer.valueOf((int) R.raw.app_attach_file_icon_video));
        oYD.put("ram", Integer.valueOf((int) R.raw.app_attach_file_icon_video));
        oYD.put("mp3pro", Integer.valueOf((int) R.raw.app_attach_file_icon_music));
        oYD.put("vqf", Integer.valueOf((int) R.raw.app_attach_file_icon_music));
        oYD.put("cd", Integer.valueOf((int) R.raw.app_attach_file_icon_music));
        oYD.put("md", Integer.valueOf((int) R.raw.app_attach_file_icon_music));
        oYD.put("mod", Integer.valueOf((int) R.raw.app_attach_file_icon_music));
        oYD.put("vorbis", Integer.valueOf((int) R.raw.app_attach_file_icon_music));
        oYD.put("au", Integer.valueOf((int) R.raw.app_attach_file_icon_music));
        oYD.put("amr", Integer.valueOf((int) R.raw.app_attach_file_icon_music));
        oYD.put("silk", Integer.valueOf((int) R.raw.app_attach_file_icon_music));
        oYD.put("wma", Integer.valueOf((int) R.raw.app_attach_file_icon_music));
        oYD.put("mmf", Integer.valueOf((int) R.raw.app_attach_file_icon_music));
        oYD.put("mid", Integer.valueOf((int) R.raw.app_attach_file_icon_music));
        oYD.put("midi", Integer.valueOf((int) R.raw.app_attach_file_icon_music));
        oYD.put("mp3", Integer.valueOf((int) R.raw.app_attach_file_icon_music));
        oYD.put("aac", Integer.valueOf((int) R.raw.app_attach_file_icon_music));
        oYD.put("ape", Integer.valueOf((int) R.raw.app_attach_file_icon_music));
        oYD.put("aiff", Integer.valueOf((int) R.raw.app_attach_file_icon_music));
        oYD.put("aif", Integer.valueOf((int) R.raw.app_attach_file_icon_music));
        oYD.put("jfif", Integer.valueOf((int) R.raw.app_attach_file_icon_pic));
        oYD.put("tiff", Integer.valueOf((int) R.raw.app_attach_file_icon_pic));
        oYD.put("tif", Integer.valueOf((int) R.raw.app_attach_file_icon_pic));
        oYD.put("jpe", Integer.valueOf((int) R.raw.app_attach_file_icon_pic));
        oYD.put("dib", Integer.valueOf((int) R.raw.app_attach_file_icon_pic));
        oYD.put("jpeg", Integer.valueOf((int) R.raw.app_attach_file_icon_pic));
        oYD.put("jpg", Integer.valueOf((int) R.raw.app_attach_file_icon_pic));
        oYD.put("png", Integer.valueOf((int) R.raw.app_attach_file_icon_pic));
        oYD.put("bmp", Integer.valueOf((int) R.raw.app_attach_file_icon_pic));
        oYD.put("gif", Integer.valueOf((int) R.raw.app_attach_file_icon_pic));
        oYD.put("rar", Integer.valueOf((int) R.raw.app_attach_file_icon_rar));
        oYD.put("zip", Integer.valueOf((int) R.raw.app_attach_file_icon_rar));
        oYD.put("7z", Integer.valueOf((int) R.raw.app_attach_file_icon_rar));
        oYD.put("iso", Integer.valueOf((int) R.raw.app_attach_file_icon_rar));
        oYD.put("cab", Integer.valueOf((int) R.raw.app_attach_file_icon_rar));
        oYD.put("doc", Integer.valueOf((int) R.raw.app_attach_file_icon_word));
        oYD.put("docx", Integer.valueOf((int) R.raw.app_attach_file_icon_word));
        oYD.put("ppt", Integer.valueOf((int) R.raw.app_attach_file_icon_ppt));
        oYD.put("pptx", Integer.valueOf((int) R.raw.app_attach_file_icon_ppt));
        oYD.put("xls", Integer.valueOf((int) R.raw.app_attach_file_icon_excel));
        oYD.put("xlsx", Integer.valueOf((int) R.raw.app_attach_file_icon_excel));
        oYD.put("txt", Integer.valueOf((int) R.raw.app_attach_file_icon_txt));
        oYD.put("rtf", Integer.valueOf((int) R.raw.app_attach_file_icon_txt));
        oYD.put("pdf", Integer.valueOf((int) R.raw.app_attach_file_icon_pdf));
        oYD.put("unknown", Integer.valueOf((int) R.raw.app_attach_file_icon_unknow));
        AppMethodBeat.o(106690);
    }

    public static Bitmap bd(String str, boolean z) {
        boolean z2;
        Bitmap decodeFileWithSample;
        boolean z3 = true;
        AppMethodBeat.i(106687);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(106687);
            return null;
        }
        Bitmap bitmap = tdM.get(str);
        if (bitmap != null) {
            Log.d("MicroMsg.FavExportLogic", "get bm from cache %s", str);
            AppMethodBeat.o(106687);
            return bitmap;
        } else if (z) {
            AppMethodBeat.o(106687);
            return null;
        } else if (!s.YS(str)) {
            AppMethodBeat.o(106687);
            return null;
        } else {
            Log.d("MicroMsg.FavExportLogic", "get from cache fail, try to decode from file");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            Bitmap decodeFile = MMBitmapFactory.decodeFile(str, options);
            if (decodeFile != null) {
                Log.i("MicroMsg.FavExportLogic", "bitmap recycle %s", decodeFile);
                decodeFile.recycle();
            }
            boolean z4 = LongBitmapHandler.isLongHorizontal(options.outWidth, options.outHeight) && options.outWidth > 480;
            if (!LongBitmapHandler.isLongVertical(options.outWidth, options.outHeight) || options.outHeight <= 480) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z4 || z2) {
                int i2 = options.outHeight;
                int i3 = options.outWidth;
                while (i3 * i2 > 2764800) {
                    i3 >>= 1;
                    i2 >>= 1;
                }
                Log.w("MicroMsg.FavExportLogic", "fit long picture, beg %d*%d, after %d*%d", Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight), Integer.valueOf(Math.max(1, i3)), Integer.valueOf(Math.max(1, i2)));
            }
            int exifOrientation = BackwardSupportUtil.ExifHelper.getExifOrientation(str);
            if (!MMNativeJpeg.IsJpegFile(str) || !MMNativeJpeg.isProgressive(str)) {
                decodeFileWithSample = BitmapUtil.decodeFileWithSample(str);
            } else {
                decodeFileWithSample = MMNativeJpeg.decodeAsBitmap(str);
                Object[] objArr = new Object[1];
                if (decodeFileWithSample != null) {
                    z3 = false;
                }
                objArr[0] = Boolean.valueOf(z3);
                Log.i("MicroMsg.FavExportLogic", "Progressive jpeg, result isNull:%b", objArr);
            }
            if (decodeFileWithSample == null) {
                Log.e("MicroMsg.FavExportLogic", "getSuitableBmp fail, temBmp is null, filePath = ".concat(String.valueOf(str)));
                AppMethodBeat.o(106687);
                return null;
            }
            Bitmap rotate = BitmapUtil.rotate(decodeFileWithSample, (float) exifOrientation);
            if (rotate.getByteCount() > 20971520) {
                AppMethodBeat.o(106687);
                return rotate;
            }
            tdM.put(str, rotate);
            AppMethodBeat.o(106687);
            return rotate;
        }
    }

    public static int asl(String str) {
        AppMethodBeat.i(106688);
        Integer num = oYD.get(str);
        if (num == null) {
            int intValue = oYD.get("unknown").intValue();
            AppMethodBeat.o(106688);
            return intValue;
        }
        int intValue2 = num.intValue();
        AppMethodBeat.o(106688);
        return intValue2;
    }

    @TargetApi(8)
    public static Bitmap asm(String str) {
        AppMethodBeat.i(106689);
        Bitmap bitmap = null;
        if (d.oD(8)) {
            bitmap = BitmapUtil.createVideoThumbnail(str, 1);
        }
        AppMethodBeat.o(106689);
        return bitmap;
    }

    public static void cVJ() {
    }
}
