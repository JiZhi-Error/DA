package com.tencent.tav.core.audio;

public interface IAudioExportTask {
    void cancel();

    void setExportCallback(ExportCallback exportCallback);

    void start();
}
