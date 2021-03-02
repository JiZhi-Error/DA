package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bw.b;
import com.tencent.mm.g.a.ya;
import com.tencent.mm.g.a.yd;
import com.tencent.mm.plugin.record.b.w;
import com.tencent.mm.plugin.record.b.x;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import java.io.IOException;
import java.util.Iterator;
import java.util.regex.Pattern;

public final class i {
    public BaseAdapter BIB;
    a BIC;
    boolean BID;
    private IListener BIE = new IListener<yd>() {
        /* class com.tencent.mm.plugin.record.ui.i.AnonymousClass1 */

        {
            AppMethodBeat.i(161428);
            this.__eventId = yd.class.getName().hashCode();
            AppMethodBeat.o(161428);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(yd ydVar) {
            AppMethodBeat.i(27995);
            final yd ydVar2 = ydVar;
            if (ydVar2 instanceof yd) {
                final String str = ydVar2.eey.id;
                final int i2 = ydVar2.eey.ret;
                new MMHandler().postDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.record.ui.i.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        byte[] bArr;
                        boolean find;
                        AppMethodBeat.i(27994);
                        try {
                            w Vx = i.this.Vx(new Integer(str).intValue());
                            if (Vx == null) {
                                AppMethodBeat.o(27994);
                                return;
                            }
                            if (i2 == 0) {
                                Vx.BHr = Util.escapeSqlValue(ydVar2.eey.eez);
                                Vx.brand = Util.escapeSqlValue(Util.nullAsNil(ydVar2.eey.ecu));
                                if (ydVar2.eey.ees == null) {
                                    bArr = new byte[0];
                                } else {
                                    bArr = ydVar2.eey.ees;
                                }
                                Vx.AqP = new b(bArr);
                                Vx.eeA = ydVar2.eey.eeA;
                                Vx.status = 2;
                                i.this.BIB.notifyDataSetChanged();
                                if (i.this.BID) {
                                    final int i2 = Vx.id + 1;
                                    if (i2 >= i.this.BIC.BHs.size()) {
                                        AppMethodBeat.o(27994);
                                        return;
                                    }
                                    i iVar = i.this;
                                    String str = i.this.BIC.BHs.get(i2).desc;
                                    if (Util.isNullOrNil(str)) {
                                        find = false;
                                    } else {
                                        int indexOf = str.indexOf(58);
                                        if (indexOf != -1) {
                                            str = str.substring(indexOf + 1);
                                        }
                                        if (LocaleUtil.isChineseAppLang()) {
                                            find = iVar.BIF.matcher(str).find();
                                        } else {
                                            find = iVar.BIG.matcher(str).find();
                                        }
                                    }
                                    if (!find) {
                                        AppMethodBeat.o(27994);
                                        return;
                                    }
                                    MMHandlerThread.postToMainThread(new Runnable() {
                                        /* class com.tencent.mm.plugin.record.ui.i.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                        public final void run() {
                                            AppMethodBeat.i(232046);
                                            i.this.aK(i2, false);
                                            AppMethodBeat.o(232046);
                                        }
                                    });
                                    AppMethodBeat.o(27994);
                                    return;
                                }
                            } else {
                                if (i2 == 3) {
                                    h.cD(i.this.context, i.this.context.getResources().getString(R.string.b35));
                                } else if (i2 != 5) {
                                    h.cD(i.this.context, i.this.context.getResources().getString(R.string.b30));
                                }
                                i.this.BIB.notifyDataSetChanged();
                            }
                            AppMethodBeat.o(27994);
                        } catch (Exception e2) {
                            Log.e("MicroMsg.TranslateHelper", "translateListener id:%s Exception:%s %s", Util.nullAs(str, ""), e2.getClass().getSimpleName(), e2.getMessage());
                            AppMethodBeat.o(27994);
                        }
                    }
                }, (long) (i2 == 5 ? 2000 : 0));
            }
            AppMethodBeat.o(27995);
            return false;
        }
    };
    Pattern BIF = Pattern.compile("[a-zA-z]");
    Pattern BIG = Pattern.compile("[一-龥]");
    Context context;

    public i(Context context2, BaseAdapter baseAdapter, a aVar) {
        AppMethodBeat.i(27996);
        this.context = context2;
        this.BIB = baseAdapter;
        this.BIC = aVar;
        EventCenter.instance.addListener(this.BIE);
        AppMethodBeat.o(27996);
    }

    public final void aK(int i2, boolean z) {
        byte[] bArr;
        AppMethodBeat.i(27997);
        w Vx = Vx(i2);
        if (!Util.isNullOrNil(Vx.BHr) && !z) {
            Vx.status = 2;
            this.BIB.notifyDataSetChanged();
            AppMethodBeat.o(27997);
        } else if (i2 >= this.BIC.BHs.size()) {
            AppMethodBeat.o(27997);
        } else {
            ya yaVar = new ya();
            yaVar.eep.eer = false;
            yaVar.eep.id = String.valueOf(i2);
            yaVar.eep.eeq = this.BIC.BHs.get(i2).desc;
            ya.a aVar = yaVar.eep;
            if (Vx.AqP != null) {
                bArr = Vx.AqP.zy;
            } else {
                bArr = null;
            }
            aVar.ees = bArr;
            yaVar.eep.type = 4;
            EventCenter.instance.publish(yaVar);
            Vx.status = 1;
            this.BIB.notifyDataSetChanged();
            this.BID = true;
            AppMethodBeat.o(27997);
        }
    }

    public final w Vx(int i2) {
        AppMethodBeat.i(27998);
        Iterator<w> it = this.BIC.BHt.iAd.iterator();
        while (it.hasNext()) {
            w next = it.next();
            if (i2 == next.id) {
                AppMethodBeat.o(27998);
                return next;
            }
        }
        w wVar = new w();
        wVar.id = i2;
        wVar.status = 0;
        this.BIC.BHt.iAd.add(wVar);
        AppMethodBeat.o(27998);
        return wVar;
    }

    public final byte[] eID() {
        AppMethodBeat.i(27999);
        EventCenter.instance.removeListener(this.BIE);
        x xVar = new x();
        if (!(this.BIC == null || this.BIC.BHt == null || this.BIC.BHt.iAd == null)) {
            Iterator<w> it = this.BIC.BHt.iAd.iterator();
            while (it.hasNext()) {
                w next = it.next();
                if (!Util.isNullOrNil(next.BHr)) {
                    xVar.iAd.add(next);
                }
            }
        }
        this.BIB = null;
        this.BIC = null;
        this.context = null;
        try {
            byte[] byteArray = xVar.toByteArray();
            AppMethodBeat.o(27999);
            return byteArray;
        } catch (IOException e2) {
            AppMethodBeat.o(27999);
            return null;
        }
    }
}
