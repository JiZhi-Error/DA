package com.tencent.mm.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.ConcurrentHashMap;

public final class ProcessService {
    public static ConcurrentHashMap<String, b> NKc = new ConcurrentHashMap<>();

    static {
        AppMethodBeat.i(133212);
        AppMethodBeat.o(133212);
    }

    public static class MMProcessService extends CommonProcessService {
        private CoreService.a glf = null;

        @Override // com.tencent.mm.service.CommonProcessService
        public final String getTag() {
            return "MicroMsg.MMProcessService";
        }

        @Override // com.tencent.mm.service.CommonProcessService
        public void onCreate() {
            AppMethodBeat.i(133210);
            try {
                this.glf = (CoreService.a) Class.forName("com.tencent.mm.platformtools.BroadcastHelper").newInstance();
                Log.d("MicroMsg.MMProcessService", "broadcastRegisterHelper = %s", this.glf);
                this.glf.registerBroadcasts();
            } catch (Exception e2) {
                Log.e("MicroMsg.MMProcessService", "onCreate Class.forName(com.tencent.mm.platformtools.BroadcastHelper) Exception = %s ", e2.getMessage());
            }
            super.onCreate();
            AppMethodBeat.o(133210);
        }

        @Override // com.tencent.mm.service.CommonProcessService
        public void onDestroy() {
            AppMethodBeat.i(133211);
            if (this.glf != null) {
                try {
                    this.glf.unRegisterBroadcasts();
                } catch (Exception e2) {
                    Log.e("MicroMsg.MMProcessService", "onDestroy unRegisterBroadcasts() Exception = %s ", e2.getMessage());
                }
            }
            super.onDestroy();
            AppMethodBeat.o(133211);
        }
    }

    public static class DexOptProcessService extends CommonProcessService {
        @Override // com.tencent.mm.service.CommonProcessService
        public final String getTag() {
            return "MicroMsg.DexOptProcessService";
        }
    }

    public static class SandBoxProcessService extends CommonProcessService {
        @Override // com.tencent.mm.service.CommonProcessService
        public final String getTag() {
            return "MicroMsg.SandBoxProcessService";
        }
    }

    public static class PushProcessServicer extends CommonProcessService {
        @Override // com.tencent.mm.service.CommonProcessService
        public final String getTag() {
            return "MicroMsg.PushProcessServicer";
        }
    }

    public static class ToolsProcessService extends CommonProcessService {
        @Override // com.tencent.mm.service.CommonProcessService
        public final String getTag() {
            return "MicroMsg.ToolsProcessService";
        }
    }

    public static class ExDeviceProcessService extends CommonProcessService {
        @Override // com.tencent.mm.service.CommonProcessService
        public final String getTag() {
            return "MicroMsg.ExDeviceProcessService";
        }
    }

    public static class SupportProcessService extends CommonProcessService {
        @Override // com.tencent.mm.service.CommonProcessService
        public final String getTag() {
            return "MicroMsg.SupportProcessService";
        }
    }

    public static class ToolsmpProcessService extends CommonProcessService {
        @Override // com.tencent.mm.service.CommonProcessService
        public final String getTag() {
            return "MicroMsg.ToolsmpProcessService";
        }
    }

    public static class LiteProcessService extends CommonProcessService {
        @Override // com.tencent.mm.service.CommonProcessService
        public final String getTag() {
            return "MicroMsg.LiteProcessService";
        }
    }
}
