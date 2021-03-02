package com.tencent.mm.pluginsdk.c;

import com.tencent.mm.g.a.me;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;

public abstract class d implements MStorage.IOnStorageChange {
    public int JTn = 0;

    public abstract IEvent azl(String str);

    public abstract MStorage dSG();

    public final void LW() {
        MStorage dSG;
        if (this.JTn == 0 && (dSG = dSG()) != null) {
            dSG.add(this);
        }
        this.JTn++;
    }

    public final void unregister() {
        MStorage dSG;
        if (this.JTn != 0) {
            this.JTn--;
            if (this.JTn == 0 && (dSG = dSG()) != null) {
                dSG.remove(this);
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
    public void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        me meVar = new me();
        meVar.dRE.dRF = azl(str);
        EventCenter.instance.publish(meVar);
    }
}
