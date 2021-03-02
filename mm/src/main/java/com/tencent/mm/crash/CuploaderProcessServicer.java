package com.tencent.mm.crash;

import com.tencent.mm.service.CommonProcessService;

public class CuploaderProcessServicer extends CommonProcessService {
    @Override // com.tencent.mm.service.CommonProcessService
    public final String getTag() {
        return "MicroMsg.CuploaderProcessService";
    }
}
