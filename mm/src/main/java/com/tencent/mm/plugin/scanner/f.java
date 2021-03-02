package com.tencent.mm.plugin.scanner;

import com.tencent.mm.kernel.b.d;
import com.tencent.mm.plugin.scanner.util.p;

public interface f extends d {
    String genScanCaptureImgPath(String str);

    String genScanTmpImgPath(String str);

    String getAccScannerPath();

    p getScanCdnService();

    String getScanImageSaveDir();
}
