package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.KUUIDService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.UUID;

public class KindaUUIDService implements KUUIDService {
    @Override // com.tencent.kinda.gen.KUUIDService
    public String getUuid() {
        AppMethodBeat.i(18659);
        String uuid = UUID.randomUUID().toString();
        AppMethodBeat.o(18659);
        return uuid;
    }
}
