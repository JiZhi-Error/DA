package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Node;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;

public final class zzw implements CapabilityInfo {
    private final String name;
    private final Set<Node> zzbt;

    public zzw(CapabilityInfo capabilityInfo) {
        this(capabilityInfo.getName(), capabilityInfo.getNodes());
        AppMethodBeat.i(101459);
        AppMethodBeat.o(101459);
    }

    private zzw(String str, Set<Node> set) {
        this.name = str;
        this.zzbt = set;
    }

    @Override // com.google.android.gms.wearable.CapabilityInfo
    public final String getName() {
        return this.name;
    }

    @Override // com.google.android.gms.wearable.CapabilityInfo
    public final Set<Node> getNodes() {
        return this.zzbt;
    }
}
