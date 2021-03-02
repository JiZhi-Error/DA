package com.tencent.mm.plugin.exdevice.model;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.f;
import com.tencent.mm.av.a.d.b;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tavkit.component.TAVExporter;
import java.io.IOException;
import java.util.List;

public final class ac {
    private Context context;
    boolean ifz;
    private View rAO;
    private TextView rAP;
    private TextView rAQ;
    private TextView rAR;
    private TextView rAS;
    private View rAT;
    boolean rAU;
    Dialog rAV;
    private int width;

    public interface a {
        void anx(String str);
    }

    public static final String fb(Context context2) {
        AppMethodBeat.i(23445);
        String z = aa.z(new o(context2.getCacheDir(), "sport_share_bitmap.jpg").her());
        AppMethodBeat.o(23445);
        return z;
    }

    public final void a(Context context2, String str, String str2, String str3, final a aVar) {
        AppMethodBeat.i(23446);
        if (this.rAU) {
            AppMethodBeat.o(23446);
            return;
        }
        this.rAU = true;
        this.ifz = false;
        if (this.rAV == null && !Util.isNullOrNil(str3)) {
            context2.getString(R.string.zb);
            this.rAV = h.a(context2, context2.getString(R.string.c24), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.exdevice.model.ac.AnonymousClass1 */

                public final void onCancel(DialogInterface dialogInterface) {
                    ac.this.ifz = true;
                }
            });
            this.rAV.show();
        }
        this.context = context2;
        this.width = TAVExporter.VIDEO_EXPORT_HEIGHT;
        if (this.width > com.tencent.mm.cb.a.jn(context2)) {
            this.width = com.tencent.mm.cb.a.jn(context2);
        }
        this.rAO = LayoutInflater.from(context2).inflate(R.layout.a5c, (ViewGroup) null);
        this.rAP = (TextView) this.rAO.findViewById(R.id.c6_);
        this.rAQ = (TextView) this.rAO.findViewById(R.id.c69);
        this.rAR = (TextView) this.rAO.findViewById(R.id.c6g);
        this.rAS = (TextView) this.rAO.findViewById(R.id.c6f);
        this.rAT = this.rAO.findViewById(R.id.a34);
        this.rAP.setText(str);
        this.rAR.setText(str2);
        a.b.a((ImageView) this.rAO.findViewById(R.id.wn), z.aTY(), 0.5f, false);
        ImageView imageView = (ImageView) this.rAO.findViewById(R.id.a2y);
        this.rAO.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.rAO.measure(View.MeasureSpec.makeMeasureSpec(this.width, 1073741824), View.MeasureSpec.makeMeasureSpec(this.width, 1073741824));
        this.rAO.layout(0, 0, this.width, this.width);
        if (!Util.isNullOrNil(str3)) {
            ad.cKO().a(str3, imageView, new com.tencent.mm.av.a.c.h() {
                /* class com.tencent.mm.plugin.exdevice.model.ac.AnonymousClass2 */

                @Override // com.tencent.mm.av.a.c.h
                public final void b(String str, View view) {
                }

                @Override // com.tencent.mm.av.a.c.h
                public final Bitmap a(String str, View view, b bVar) {
                    return null;
                }

                @Override // com.tencent.mm.av.a.c.h
                public final void b(String str, View view, b bVar) {
                    AppMethodBeat.i(23443);
                    if (ac.this.ifz) {
                        ac.this.rAU = false;
                        AppMethodBeat.o(23443);
                        return;
                    }
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.exdevice.model.ac.AnonymousClass2.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(23442);
                            if (ac.this.rAV.isShowing()) {
                                ac.this.rAV.dismiss();
                            }
                            AppMethodBeat.o(23442);
                        }
                    });
                    aVar.anx(ac.this.aa(bVar.bitmap));
                    ac.this.rAU = false;
                    AppMethodBeat.o(23443);
                }
            });
            AppMethodBeat.o(23446);
            return;
        }
        imageView.setImageResource(R.color.kw);
        aVar.anx(aa(null));
        this.rAU = false;
        AppMethodBeat.o(23446);
    }

    /* access modifiers changed from: package-private */
    public final String aa(Bitmap bitmap) {
        final int[] iArr;
        AppMethodBeat.i(23447);
        if (bitmap != null) {
            iArr = ao.aK(bitmap);
        } else {
            iArr = new int[]{-1, WebView.NIGHT_MODE_COLOR};
        }
        AnonymousClass3 r1 = new ShapeDrawable.ShaderFactory() {
            /* class com.tencent.mm.plugin.exdevice.model.ac.AnonymousClass3 */

            public final Shader resize(int i2, int i3) {
                AppMethodBeat.i(23444);
                LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, (float) i3, new int[]{0, iArr[0]}, new float[]{0.0f, 1.0f}, Shader.TileMode.REPEAT);
                AppMethodBeat.o(23444);
                return linearGradient;
            }
        };
        PaintDrawable paintDrawable = new PaintDrawable();
        paintDrawable.setShape(new RectShape());
        paintDrawable.setShaderFactory(r1);
        this.rAT.setBackgroundDrawable(paintDrawable);
        this.rAP.setTextColor(iArr[1]);
        this.rAQ.setTextColor(iArr[1]);
        this.rAR.setTextColor(iArr[1]);
        this.rAS.setTextColor(iArr[1]);
        Bitmap createBitmap = Bitmap.createBitmap(this.width, this.width, Bitmap.Config.ARGB_8888);
        this.rAO.draw(new Canvas(createBitmap));
        o oVar = new o(fb(this.context));
        if (oVar.exists()) {
            oVar.delete();
        }
        try {
            BitmapUtil.saveBitmapToImage(createBitmap, 100, Bitmap.CompressFormat.JPEG, aa.z(oVar.her()), true);
        } catch (IOException e2) {
        }
        String z = aa.z(oVar.her());
        AppMethodBeat.o(23447);
        return z;
    }

    public static boolean a(Context context2, String str, String str2, String str3, String str4) {
        String str5;
        AppMethodBeat.i(23448);
        ag.bah();
        List<String> aZG = f.aZG();
        if (aZG.size() > 0) {
            str5 = aZG.get(0);
        } else {
            str5 = null;
        }
        WXImageObject wXImageObject = new WXImageObject();
        wXImageObject.setImagePath(str2);
        String displayName = com.tencent.mm.model.aa.getDisplayName(str5);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.title = displayName;
        wXMediaMessage.description = str4;
        wXMediaMessage.setThumbImage(BitmapUtil.decodeFile(str2, null));
        tt ttVar = new tt();
        ttVar.eaf.dCE = wXMediaMessage;
        ttVar.eaf.appId = "wx7fa037cc7dfabad5";
        ttVar.eaf.appName = context2.getString(R.string.c2n);
        ttVar.eaf.toUser = str;
        ttVar.eaf.dMG = 2;
        if (Util.isNullOrNil(str5)) {
            ttVar.eaf.eai = null;
        } else {
            ttVar.eaf.eag = str5;
            ttVar.eaf.eah = displayName;
        }
        boolean publish = EventCenter.instance.publish(ttVar);
        if (!Util.isNullOrNil(str3)) {
            tw twVar = new tw();
            twVar.eaq.dkV = str;
            twVar.eaq.content = str3;
            twVar.eaq.type = ab.JG(str);
            twVar.eaq.flags = 0;
            EventCenter.instance.publish(twVar);
        }
        AppMethodBeat.o(23448);
        return publish;
    }
}
