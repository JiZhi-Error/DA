package com.tencent.mm.aa.b;

import org.json.JSONObject;

public abstract class c implements e {
    private int index;
    public String name;

    public abstract JSONObject toJSONObject();

    public c(String str) {
        this.name = str;
    }

    public c(String str, int i2) {
        this.name = str;
        this.index = i2;
    }

    @Override // com.tencent.mm.aa.b.e
    public final String getName() {
        return this.name;
    }

    @Override // com.tencent.mm.aa.b.e
    public final int getIndex() {
        return this.index;
    }
}
