package com.tencent.mm.plugin.ipcall.model;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.model.h.b;
import com.tencent.mm.plugin.ipcall.model.h.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;

public final class a {
    private static a yot = null;
    private long endTime = -1;
    MMHandler handler = new MMHandler(Looper.getMainLooper()) {
        /* class com.tencent.mm.plugin.ipcall.model.a.AnonymousClass1 */

        /* JADX WARNING: Removed duplicated region for block: B:14:0x006e  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0084  */
        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void handleMessage(android.os.Message r19) {
            /*
            // Method dump skipped, instructions count: 292
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ipcall.model.a.AnonymousClass1.handleMessage(android.os.Message):void");
        }
    };
    private boolean isLoading = false;
    private long startTime = -1;
    public ArrayList<AbstractC1439a> yos = new ArrayList<>();

    /* renamed from: com.tencent.mm.plugin.ipcall.model.a$a  reason: collision with other inner class name */
    public interface AbstractC1439a {
        void eac();
    }

    private a() {
        AppMethodBeat.i(25329);
        AppMethodBeat.o(25329);
    }

    public static a eab() {
        AppMethodBeat.i(25330);
        if (yot == null) {
            yot = new a();
        }
        a aVar = yot;
        AppMethodBeat.o(25330);
        return aVar;
    }

    public final void a(AbstractC1439a aVar, boolean z) {
        AppMethodBeat.i(25331);
        if (aVar != null) {
            this.yos.add(aVar);
        }
        if (this.isLoading) {
            Log.d("MicroMsg.IPCallAddressBookLoader", "loadAllAddressItem, isLoading is true, ignore");
            AppMethodBeat.o(25331);
            return;
        }
        this.startTime = System.currentTimeMillis();
        if (b.eaW().size() == 0 || !z) {
            Log.d("MicroMsg.IPCallAddressBookLoader", "loadFromSystemAddressBook");
            long currentTimeMillis = System.currentTimeMillis();
            new b();
            ArrayList<c> eaV = b.eaV();
            Log.d("MicroMsg.IPCallAddressBookLoader", "getAllAddressItemFromSystemPhoneBook, used %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            Message obtainMessage = this.handler.obtainMessage();
            obtainMessage.obj = eaV;
            this.handler.sendMessage(obtainMessage);
            this.isLoading = true;
            AppMethodBeat.o(25331);
            return;
        }
        AppMethodBeat.o(25331);
    }
}
