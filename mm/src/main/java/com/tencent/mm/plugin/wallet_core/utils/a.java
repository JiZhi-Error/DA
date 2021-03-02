package com.tencent.mm.plugin.wallet_core.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.aj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.wallet_core.c.f;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wallet_core.ui.view.c;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public final class a {
    ArrayList<b> Iou = new ArrayList<>();
    private IListener Iov = new IListener<aj>() {
        /* class com.tencent.mm.plugin.wallet_core.utils.a.AnonymousClass1 */

        {
            AppMethodBeat.i(160891);
            this.__eventId = aj.class.getName().hashCode();
            AppMethodBeat.o(160891);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aj ajVar) {
            b remove;
            e eVar;
            ImageView imageView;
            AppMethodBeat.i(71613);
            a.this.mLock.lock();
            while (a.this.Iou != null && a.this.Iou.size() > 0 && (remove = a.this.Iou.remove(0)) != null) {
                Bankcard bankcard = remove.Hww;
                ImageView imageView2 = remove.IoF.get();
                if (imageView2 != null) {
                    String str = (String) imageView2.getTag(R.id.jf6);
                    if (!Util.isNullOrNil(str) && ((!z.aUo() && str.equals(bankcard.field_bankcardType)) || (z.aUo() && str.equals(bankcard.field_bankName)))) {
                        if (bankcard.HVM != null) {
                            eVar = bankcard.HVM;
                        } else if (z.aUo()) {
                            eVar = com.tencent.mm.plugin.wallet_core.d.b.j(imageView2.getContext(), bankcard.field_bankName, false);
                        } else {
                            eVar = com.tencent.mm.plugin.wallet_core.d.b.j(imageView2.getContext(), bankcard.field_bankcardType, bankcard.fQa());
                        }
                        a aVar = a.this;
                        if (eVar == null || remove == null || remove.IoF == null || remove.IoF.get() == null) {
                            Log.e("MicroMsg.BankcardLogoHelper", "bankUrls == null");
                        } else {
                            Log.d("MicroMsg.BankcardLogoHelper", "setLogo bankLogoUrl = " + eVar.AAU);
                            ImageView imageView3 = remove.IoF.get();
                            if (!Util.isNullOrNil(eVar.AAU)) {
                                imageView3.post(new Runnable(remove, imageView3, u.a(new c(eVar.AAU))) {
                                    /* class com.tencent.mm.plugin.wallet_core.utils.a.AnonymousClass2 */
                                    final /* synthetic */ b Ioy;
                                    final /* synthetic */ Bitmap Ioz;
                                    final /* synthetic */ ImageView rCk;

                                    {
                                        this.Ioy = r2;
                                        this.rCk = r3;
                                        this.Ioz = r4;
                                    }

                                    public final void run() {
                                        AppMethodBeat.i(71614);
                                        Bankcard bankcard = this.Ioy.Hww;
                                        String str = (String) this.rCk.getTag(R.id.jf6);
                                        if (Util.isNullOrNil(str) || ((z.aUo() || !str.equals(bankcard.field_bankcardType)) && (!z.aUo() || !str.equals(bankcard.field_bankName)))) {
                                            Log.d("MicroMsg.BankcardLogoHelper", "not match tag: %s, banktype: %s, iv: %s", str, bankcard.field_bankcardType, this.rCk);
                                            AppMethodBeat.o(71614);
                                            return;
                                        }
                                        this.rCk.setImageBitmap(this.Ioz);
                                        AppMethodBeat.o(71614);
                                    }
                                });
                                remove.Ijw = eVar.AAU;
                                u.a(remove);
                            } else if (eVar.HWf > 0) {
                                imageView3.post(new Runnable(imageView3, eVar) {
                                    /* class com.tencent.mm.plugin.wallet_core.utils.a.AnonymousClass3 */
                                    final /* synthetic */ e IoA;
                                    final /* synthetic */ ImageView rCk;

                                    {
                                        this.rCk = r2;
                                        this.IoA = r3;
                                    }

                                    public final void run() {
                                        AppMethodBeat.i(71615);
                                        this.rCk.setImageResource(this.IoA.HWf);
                                        AppMethodBeat.o(71615);
                                    }
                                });
                            } else {
                                Log.e("MicroMsg.BankcardLogoHelper", "bankcard logoUrl == null");
                            }
                        }
                        a aVar2 = a.this;
                        if (!(eVar == null || remove == null || remove.IoG == null || remove.IoG.get() == null)) {
                            View view = remove.IoG.get();
                            view.post(new Runnable(view, eVar, remove) {
                                /* class com.tencent.mm.plugin.wallet_core.utils.a.AnonymousClass4 */
                                final /* synthetic */ e IoA;
                                final /* synthetic */ View IoB;
                                final /* synthetic */ b Ioy;

                                {
                                    this.IoB = r2;
                                    this.IoA = r3;
                                    this.Ioy = r4;
                                }

                                public final void run() {
                                    AppMethodBeat.i(71616);
                                    this.IoB.invalidate();
                                    int aVW = com.tencent.mm.plugin.wallet_core.ui.view.b.aVW(this.IoA.HWc);
                                    if (aVW != -1) {
                                        this.IoB.setBackgroundResource(aVW);
                                        Bitmap decodeResource = BitmapFactory.decodeResource(this.IoB.getResources(), aVW);
                                        int pixel = decodeResource.getPixel(decodeResource.getWidth() / 2, decodeResource.getHeight() / 2);
                                        Log.d("MicroMsg.BankcardLogoHelper", "local bg color: %s", Integer.valueOf(pixel));
                                        TextView textView = this.Ioy.IoI.get();
                                        if (textView != null) {
                                            textView.setTextColor(pixel);
                                        }
                                        AppMethodBeat.o(71616);
                                    } else if (!Util.isNullOrNil(this.IoA.HWc)) {
                                        c cVar = new c(this.IoA.HWc);
                                        Bitmap a2 = u.a(cVar);
                                        u.a(this.Ioy);
                                        if (a2 != null) {
                                            try {
                                                byte[] ninePatchChunk = a2.getNinePatchChunk();
                                                if (ninePatchChunk == null || !NinePatch.isNinePatchChunk(ninePatchChunk)) {
                                                    s.deleteFile(cVar.blA());
                                                }
                                            } catch (Exception e2) {
                                            }
                                        }
                                        if (a2 != null) {
                                            this.IoB.setBackgroundDrawable(com.tencent.mm.plugin.wallet_core.ui.view.b.b(this.IoB.getContext(), a2));
                                            int pixel2 = a2.getPixel(a2.getWidth() / 2, a2.getHeight() / 2);
                                            TextView textView2 = this.Ioy.IoI.get();
                                            if (textView2 != null) {
                                                Log.d("MicroMsg.BankcardLogoHelper", "server bg color: %s", Integer.valueOf(pixel2));
                                                textView2.setTextColor(pixel2);
                                            }
                                        }
                                        AppMethodBeat.o(71616);
                                    } else {
                                        if (this.IoA.HWg > 0) {
                                            this.IoB.setBackgroundResource(this.IoA.HWg);
                                        }
                                        AppMethodBeat.o(71616);
                                    }
                                }
                            });
                        }
                        a aVar3 = a.this;
                        if (!(eVar == null || remove == null || remove.IoG == null || remove.IoG.get() == null || (imageView = remove.IoH.get()) == null)) {
                            imageView.post(new Runnable(eVar, imageView, remove) {
                                /* class com.tencent.mm.plugin.wallet_core.utils.a.AnonymousClass5 */
                                final /* synthetic */ e IoA;
                                final /* synthetic */ b Ioy;
                                final /* synthetic */ ImageView rCk;

                                {
                                    this.IoA = r2;
                                    this.rCk = r3;
                                    this.Ioy = r4;
                                }

                                public final void run() {
                                    AppMethodBeat.i(71617);
                                    if (!Util.isNullOrNil(this.IoA.HWd)) {
                                        this.rCk.setImageBitmap(u.a(new c(this.IoA.HWd)));
                                        u.a(this.Ioy);
                                        AppMethodBeat.o(71617);
                                        return;
                                    }
                                    if (this.IoA.HWh > 0) {
                                        this.rCk.setImageResource(this.IoA.HWh);
                                    }
                                    AppMethodBeat.o(71617);
                                }
                            });
                        }
                    }
                }
            }
            a.this.mLock.unlock();
            AppMethodBeat.o(71613);
            return true;
        }
    };
    public LinkedList<String> Iow;
    public LinkedList<Bankcard> hhn;
    ReentrantLock mLock = new ReentrantLock();

    /* renamed from: com.tencent.mm.plugin.wallet_core.utils.a$a  reason: collision with other inner class name */
    public interface AbstractC1923a {
        void bc(Map<String, e> map);
    }

    public a() {
        AppMethodBeat.i(71627);
        EventCenter.instance.addListener(this.Iov);
        AppMethodBeat.o(71627);
    }

    /* access modifiers changed from: package-private */
    public static class b implements u.a {
        Bankcard Hww;
        String Ijw;
        WeakReference<ImageView> IoF;
        WeakReference<View> IoG = null;
        WeakReference<ImageView> IoH = null;
        WeakReference<TextView> IoI = null;
        boolean IoJ = false;

        b() {
        }

        @Override // com.tencent.mm.platformtools.u.a
        public final void k(String str, final Bitmap bitmap) {
            Object tag;
            boolean z = true;
            AppMethodBeat.i(71626);
            Log.d("MicroMsg.BankcardLogoHelper", "onGetPictureFinish " + str + ", bitmap = " + (bitmap == null));
            if (TextUtils.isEmpty(this.Ijw)) {
                Log.e("MicroMsg.BankcardLogoHelper", "mBankcardLogoUrl is empty");
                AppMethodBeat.o(71626);
                return;
            }
            if (this.IoF != null) {
                final ImageView imageView = this.IoF.get();
                Object[] objArr = new Object[6];
                objArr[0] = str;
                objArr[1] = Boolean.valueOf(bitmap == null);
                if (imageView != null) {
                    z = false;
                }
                objArr[2] = Boolean.valueOf(z);
                if (imageView == null) {
                    tag = "";
                } else {
                    tag = imageView.getTag();
                }
                objArr[3] = tag;
                objArr[4] = this.Ijw;
                objArr[5] = Boolean.valueOf(this.IoJ);
                Log.d("MicroMsg.BankcardLogoHelper", "onGetPictureFinish done notifyKey %s  bitmap is null? %s iv is null? %s iv tag: %s mBankcardLogoUrl %s, checkTagType: %s", objArr);
                if (!(imageView == null || str == null || !str.equals(this.Ijw))) {
                    if (!this.IoJ) {
                        imageView.post(new Runnable() {
                            /* class com.tencent.mm.plugin.wallet_core.utils.a.b.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(71625);
                                imageView.setImageBitmap(bitmap);
                                AppMethodBeat.o(71625);
                            }
                        });
                        imageView.setTag(R.id.jf6, null);
                    } else if (!(imageView.getTag(R.id.jf6) == null || this.Hww == null || this.Hww.field_bankcardType == null)) {
                        String str2 = (String) imageView.getTag(R.id.jf6);
                        if (!Util.isNullOrNil(str2) && str2.equals(this.Hww.field_bankcardType)) {
                            imageView.post(new Runnable() {
                                /* class com.tencent.mm.plugin.wallet_core.utils.a.b.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(71624);
                                    imageView.setImageBitmap(bitmap);
                                    AppMethodBeat.o(71624);
                                }
                            });
                            imageView.setTag(R.id.jf6, null);
                        }
                        AppMethodBeat.o(71626);
                        return;
                    }
                }
            }
            AppMethodBeat.o(71626);
        }
    }

    public final void a(Context context, Bankcard bankcard, ImageView imageView) {
        AppMethodBeat.i(71628);
        a(context, bankcard, imageView, null, null, null);
        AppMethodBeat.o(71628);
    }

    public static void m(ImageView imageView) {
        AppMethodBeat.i(71629);
        if (imageView != null) {
            imageView.setTag(R.id.jf6, null);
            imageView.setImageResource(R.drawable.cqo);
        }
        AppMethodBeat.o(71629);
    }

    public final void a(Bankcard bankcard, ImageView imageView) {
        AppMethodBeat.i(71630);
        b bVar = new b();
        bVar.Hww = bankcard;
        if (imageView != null) {
            imageView.setTag(R.id.jf6, bankcard.field_bankcardType);
            bVar.IoF = new WeakReference<>(imageView);
        }
        final e eVar = bankcard.HVM;
        if (eVar == null || bVar.IoF == null || bVar.IoF.get() == null) {
            Log.e("MicroMsg.BankcardLogoHelper", "bankUrls == null");
            AppMethodBeat.o(71630);
            return;
        }
        Log.d("MicroMsg.BankcardLogoHelper", "bankLogoUrl = " + eVar.AAU);
        final ImageView imageView2 = bVar.IoF.get();
        if (!Util.isNullOrNil(eVar.AAU)) {
            bVar.Ijw = eVar.AAU;
            bVar.IoJ = true;
            Bitmap a2 = u.a(new c(eVar.AAU));
            if (a2 != null) {
                imageView2.setImageBitmap(a2);
            }
            u.a(bVar);
            AppMethodBeat.o(71630);
        } else if (eVar.HWf > 0) {
            imageView2.post(new Runnable() {
                /* class com.tencent.mm.plugin.wallet_core.utils.a.AnonymousClass6 */

                public final void run() {
                    AppMethodBeat.i(71618);
                    imageView2.setImageResource(eVar.HWf);
                    AppMethodBeat.o(71618);
                }
            });
            AppMethodBeat.o(71630);
        } else {
            Log.e("MicroMsg.BankcardLogoHelper", "bankcard logoUrl == null");
            AppMethodBeat.o(71630);
        }
    }

    public final void a(Context context, Bankcard bankcard, ImageView imageView, View view, ImageView imageView2, TextView textView) {
        AppMethodBeat.i(71631);
        b bVar = new b();
        bVar.IoJ = false;
        bVar.Hww = bankcard;
        if (imageView != null) {
            imageView.setTag(R.id.jf6, bankcard.field_bankcardType);
            bVar.IoF = new WeakReference<>(imageView);
        }
        if (view != null) {
            bVar.IoG = new WeakReference<>(view);
        }
        if (imageView2 != null) {
            bVar.IoH = new WeakReference<>(imageView2);
        }
        if (textView != null) {
            bVar.IoI = new WeakReference<>(textView);
        }
        this.Iou.add(bVar);
        a(context, bankcard);
        AppMethodBeat.o(71631);
    }

    public final void destory() {
        AppMethodBeat.i(71632);
        EventCenter.instance.removeListener(this.Iov);
        if (this.Iou != null) {
            this.Iou.clear();
            this.Iou = null;
        }
        AppMethodBeat.o(71632);
    }

    private void a(Context context, Bankcard bankcard) {
        String str;
        AppMethodBeat.i(71633);
        if (z.aUo()) {
            str = bankcard.field_bankName;
        } else {
            str = bankcard.field_bankcardType;
        }
        if (this.Iow == null || !this.Iow.contains(str)) {
            if (!b(context, bankcard)) {
                if (this.hhn == null) {
                    this.hhn = new LinkedList<>();
                }
                this.hhn.add(bankcard);
                if (this.Iow == null) {
                    b(context, this.hhn);
                    AppMethodBeat.o(71633);
                    return;
                }
            } else {
                EventCenter.instance.publish(new aj());
            }
            AppMethodBeat.o(71633);
            return;
        }
        Log.i("MicroMsg.BankcardLogoHelper", "waiting resp:".concat(String.valueOf(str)));
        AppMethodBeat.o(71633);
    }

    private static boolean b(Context context, Bankcard bankcard) {
        e j2;
        AppMethodBeat.i(71634);
        if (z.aUo()) {
            j2 = com.tencent.mm.plugin.wallet_core.d.b.j(context, bankcard.field_bankName, false);
        } else {
            j2 = com.tencent.mm.plugin.wallet_core.d.b.j(context, bankcard.field_bankcardType, bankcard.fQa());
        }
        if (j2 == null || j2.needUpdate) {
            AppMethodBeat.o(71634);
            return false;
        }
        AppMethodBeat.o(71634);
        return true;
    }

    public final void b(final Context context, List<Bankcard> list) {
        AppMethodBeat.i(71635);
        if (list != null && list.size() > 0) {
            int size = list.size();
            this.Iow = new LinkedList<>();
            for (int i2 = 0; i2 < size; i2++) {
                Bankcard bankcard = list.get(i2);
                if (bankcard.fQb()) {
                    Log.i("MicroMsg.BankcardLogoHelper", "ignore balance");
                } else if (!b(context, bankcard)) {
                    Log.i("MicroMsg.BankcardLogoHelper", bankcard.field_bankcardType + "'s url is null or need update");
                    this.Iow.add(bankcard.field_bankcardType);
                }
            }
            if (this.Iow.size() > 0) {
                Log.i("MicroMsg.BankcardLogoHelper", "doScene to get bankcard logo");
                f fVar = new f(this.Iow);
                g.aAi();
                g.aAg().hqi.a(1650, new i() {
                    /* class com.tencent.mm.plugin.wallet_core.utils.a.AnonymousClass7 */

                    @Override // com.tencent.mm.ak.i
                    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                        AppMethodBeat.i(71619);
                        g.aAi();
                        g.aAg().hqi.b(1650, this);
                        a.this.Iow = null;
                        if (a.this.hhn != null) {
                            a.this.b(context, a.this.hhn);
                            a.this.hhn = null;
                        }
                        AppMethodBeat.o(71619);
                    }
                });
                g.aAi();
                g.aAg().hqi.a(fVar, 0);
                AppMethodBeat.o(71635);
                return;
            }
            Log.i("MicroMsg.BankcardLogoHelper", "use cache bankcard logo data");
            EventCenter.instance.publish(new aj());
        }
        AppMethodBeat.o(71635);
    }
}
