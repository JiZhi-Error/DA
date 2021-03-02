package com.tencent.mm.pluginsdk.ui.chat;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Message;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.pluginsdk.ui.chat.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;

public final class i {
    private h Kng;
    g Knh;
    p Kni;
    boolean Knj = true;
    h.a Knk;
    a Knl;
    Bitmap bitmap = null;
    private View contentView = null;
    Context context;
    ImageView dPk = null;
    View gvQ;
    SharedPreferences sp;
    View yKs;

    public interface a {
        void beZ(String str);
    }

    public i(Context context2, View view, View view2, a aVar) {
        AppMethodBeat.i(31756);
        this.context = context2;
        this.gvQ = view;
        this.yKs = view2;
        this.Kng = new h(this.context);
        this.sp = context2.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
        this.Knl = aVar;
        this.contentView = View.inflate(this.context, R.layout.qd, null);
        this.dPk = (ImageView) this.contentView.findViewById(R.id.gu6);
        this.Kni = new p(this.contentView, -2, -2, false);
        this.Kni.setBackgroundDrawable(new ColorDrawable(0));
        this.Kni.setOutsideTouchable(true);
        this.contentView.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.pluginsdk.ui.chat.i.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(31751);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/RecentImageBubble$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!(i.this.Knl == null || i.this.Knh == null)) {
                    i.this.Knl.beZ(i.this.Knh.Kne);
                }
                i.this.Kni.dismiss();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/RecentImageBubble$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(31751);
            }
        });
        AppMethodBeat.o(31756);
    }

    public final void grx() {
        AppMethodBeat.i(31757);
        if (!this.Knk.gqT()) {
            Log.w("MicroMsg.RecentImageBubble", "[checkIfShow] is not support.");
            AppMethodBeat.o(31757);
            return;
        }
        final AnonymousClass2 r0 = new MMHandler(this.context.getMainLooper()) {
            /* class com.tencent.mm.pluginsdk.ui.chat.i.AnonymousClass2 */

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                AppMethodBeat.i(31752);
                i iVar = i.this;
                if (!iVar.Knk.gqT()) {
                    Log.w("MicroMsg.RecentImageBubble", "[checkIfShow] is not support.");
                    AppMethodBeat.o(31752);
                } else if (iVar.dPk == null || iVar.Knh == null || iVar.bitmap == null || iVar.Kni == null || iVar.gvQ == null || iVar.yKs == null) {
                    AppMethodBeat.o(31752);
                } else {
                    iVar.dPk.setImageBitmap(iVar.bitmap);
                    int i2 = iVar.Knj ? 83 : 85;
                    int i3 = iVar.Knj ? 0 : 10;
                    int yFromBottom = iVar.Knk != null ? iVar.Knk.getYFromBottom() : iVar.yKs.getHeight();
                    if (Build.VERSION.SDK_INT >= 21) {
                        Rect gJG = ao.gJG();
                        i3 = iVar.Knj ? 0 : i3 + gJG.right;
                        yFromBottom += gJG.bottom;
                        Log.i("MicroMsg.RecentImageBubble", "recent bubble navbar height %s %s", Integer.valueOf(gJG.right), Integer.valueOf(gJG.bottom));
                    }
                    if ((iVar.context instanceof Activity) && !((Activity) iVar.context).isFinishing() && !((Activity) iVar.context).isDestroyed()) {
                        try {
                            iVar.Kni.showAtLocation(iVar.gvQ, i2, i3, yFromBottom);
                        } catch (NullPointerException e2) {
                            Log.printErrStackTrace("MicroMsg.RecentImageBubble", e2, "", new Object[0]);
                        }
                    }
                    new MTimerHandler(new MTimerHandler.CallBack() {
                        /* class com.tencent.mm.pluginsdk.ui.chat.i.AnonymousClass4 */

                        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                        public final boolean onTimerExpired() {
                            AppMethodBeat.i(31755);
                            i iVar = i.this;
                            if (iVar.Kni != null) {
                                iVar.Kni.dismiss();
                            }
                            AppMethodBeat.o(31755);
                            return false;
                        }
                    }, false).startTimer(10000);
                    AppMethodBeat.o(31752);
                }
            }
        };
        bg.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.pluginsdk.ui.chat.i.AnonymousClass3 */

            public final void run() {
                int i2;
                int i3;
                boolean z;
                AppMethodBeat.i(31753);
                i iVar = i.this;
                String gry = iVar.gry();
                if (gry == null) {
                    z = false;
                } else {
                    int aiE = (int) iVar.aiE(70);
                    int aiE2 = (int) iVar.aiE(120);
                    int exifOrientation = BackwardSupportUtil.ExifHelper.getExifOrientation(gry);
                    if (exifOrientation == 90 || exifOrientation == 270) {
                        i3 = aiE;
                        i2 = aiE2;
                    } else {
                        i3 = aiE2;
                        i2 = aiE;
                    }
                    int aiE3 = (int) iVar.aiE(4);
                    Bitmap extractThumbNail = BitmapUtil.extractThumbNail(gry, i3, i2, true);
                    if (extractThumbNail != null) {
                        iVar.bitmap = BitmapUtil.getRoundedCornerBitmap(BitmapUtil.rotate(extractThumbNail, (float) exifOrientation), true, (float) aiE3);
                        iVar.sp.edit().putString("chattingui_recent_shown_image_path", iVar.Knh.Kne).commit();
                        Log.d("MicroMsg.RecentImageBubble", "check ok");
                        z = true;
                    } else {
                        Log.e("MicroMsg.RecentImageBubble", "image hits hole.");
                        z = false;
                    }
                }
                if (z) {
                    r0.sendEmptyMessage(0);
                    AppMethodBeat.o(31753);
                    return;
                }
                Log.d("MicroMsg.RecentImageBubble", "check false");
                AppMethodBeat.o(31753);
            }

            public final String toString() {
                AppMethodBeat.i(31754);
                String str = super.toString() + "|checkIfShow";
                AppMethodBeat.o(31754);
                return str;
            }
        });
        AppMethodBeat.o(31757);
    }

    /* access modifiers changed from: package-private */
    public final float aiE(int i2) {
        AppMethodBeat.i(31759);
        float applyDimension = TypedValue.applyDimension(1, (float) i2, this.context.getResources().getDisplayMetrics());
        AppMethodBeat.o(31759);
        return applyDimension;
    }

    public final synchronized String gry() {
        g gVar;
        boolean z;
        boolean z2;
        boolean z3;
        String str;
        AppMethodBeat.i(31758);
        if (this.Kng == null) {
            Log.d("MicroMsg.RecentImageBubble", "because of imageQuery == null");
            gVar = null;
        } else {
            ArrayList<g> grw = this.Kng.grw();
            if (grw == null || grw.size() == 0) {
                Log.d("MicroMsg.RecentImageBubble", "because of items == null || items.size() == 0");
                gVar = null;
            } else {
                gVar = grw.get(0);
                if (gVar != null) {
                    if (Util.secondsToNow(gVar.Knf) < 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        Log.e("MicroMsg.RecentImageBubble", "we found u have a future pic that lead to forbid this featur. file : %s", gVar.Kne);
                        gVar = null;
                    }
                }
                if (gVar == null || gVar.Kne == null || !gVar.Kne.contains(com.tencent.mm.loader.j.b.aKz())) {
                    if (gVar != null) {
                        if (Util.secondsToNow(gVar.Knf) <= 30) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            if (this.sp.getString("chattingui_recent_shown_image_path", "").equals(gVar.Kne)) {
                                Log.d("MicroMsg.RecentImageBubble", "because of recentImage.equals(imageItem.orginalPath)");
                                gVar = null;
                            }
                        }
                    }
                    Object[] objArr = new Object[1];
                    if (gVar == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objArr[0] = Boolean.valueOf(z);
                    Log.d("MicroMsg.RecentImageBubble", "because of checkAddDate(generateDate) == false, or imageItem == null : %s", objArr);
                    gVar = null;
                } else {
                    gVar = null;
                }
            }
        }
        this.Knh = gVar;
        if (this.Knh == null) {
            AppMethodBeat.o(31758);
            str = null;
        } else {
            str = this.Knh.thumbPath;
            if (this.Knh.thumbPath == null) {
                str = this.Knh.Kne;
            }
            AppMethodBeat.o(31758);
        }
        return str;
    }
}
