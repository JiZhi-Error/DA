package com.danikula.videocache.file;

import java.io.File;

public class UnlimitedDiskUsage implements DiskUsage {
    @Override // com.danikula.videocache.file.DiskUsage
    public void touch(File file) {
    }
}
