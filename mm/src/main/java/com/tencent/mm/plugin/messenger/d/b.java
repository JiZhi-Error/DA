package com.tencent.mm.plugin.messenger.d;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Map;
import junit.framework.Assert;

public abstract class b {
    public WeakReference<AbstractC1472b> zqO = null;

    /* renamed from: com.tencent.mm.plugin.messenger.d.b$b  reason: collision with other inner class name */
    public interface AbstractC1472b {
        void a(long j2, LinkedList<String> linkedList, int i2);

        void a(View view, a aVar);
    }

    /* access modifiers changed from: protected */
    public abstract CharSequence b(Map<String, String> map, String str, Bundle bundle, WeakReference<Context> weakReference, WeakReference<NeatTextView> weakReference2);

    /* access modifiers changed from: protected */
    public abstract String eiT();

    public b(AbstractC1472b bVar) {
        Assert.assertNotNull(bVar);
        this.zqO = new WeakReference<>(bVar);
        ((e) g.af(e.class)).a(eiT(), new e.b() {
            /* class com.tencent.mm.plugin.messenger.d.b.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.messenger.a.e.b
            public final CharSequence a(Map<String, String> map, String str, Bundle bundle, WeakReference<Context> weakReference, WeakReference<NeatTextView> weakReference2) {
                AppMethodBeat.i(194498);
                String string = bundle.getString("conv_talker_username", "");
                if (map == null) {
                    Log.w("MicroMsg.SysMsgTemp.SysMsgTemplateLinkHandlerBase", "hy: non map!!");
                    AppMethodBeat.o(194498);
                    return null;
                } else if (Util.isNullOrNil(str)) {
                    Log.w("MicroMsg.SysMsgTemp.SysMsgTemplateLinkHandlerBase", "hy: non header!!");
                    AppMethodBeat.o(194498);
                    return null;
                } else if (Util.isNullOrNil(string)) {
                    Log.w("MicroMsg.SysMsgTemp.SysMsgTemplateLinkHandlerBase", "hy: not resolved talker!!");
                    AppMethodBeat.o(194498);
                    return null;
                } else {
                    CharSequence b2 = b.this.b(map, str, bundle, weakReference, weakReference2);
                    AppMethodBeat.o(194498);
                    return b2;
                }
            }
        });
    }

    public final void a(long j2, LinkedList<String> linkedList, int i2) {
        if (this.zqO != null && this.zqO.get() != null) {
            this.zqO.get().a(j2, linkedList, i2);
        }
    }

    public void release() {
        ((e) g.af(e.class)).aDU(eiT());
    }

    public class a {
        public String link;
        public String username;

        public a() {
        }
    }
}
