package com.tencent.mm.plugin.nfc.b;

import android.nfc.Tag;

public abstract class b {
    protected Tag AEe;
    public byte[] AEf = null;

    public boolean a(Tag tag) {
        this.AEe = tag;
        if (tag == null) {
            return true;
        }
        this.AEf = tag.getId();
        return true;
    }
}
