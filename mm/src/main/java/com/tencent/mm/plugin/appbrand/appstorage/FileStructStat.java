package com.tencent.mm.plugin.appbrand.appstorage;

public class FileStructStat {
    public long st_atime;
    public long st_ctime;
    public int st_mode;
    public long st_mtime;
    public long st_size;

    public void fillAnother(FileStructStat fileStructStat) {
        if (fileStructStat != null) {
            fileStructStat.st_mode = this.st_mode;
            fileStructStat.st_size = this.st_size;
            fileStructStat.st_atime = this.st_atime;
            fileStructStat.st_mtime = this.st_mtime;
            fileStructStat.st_ctime = this.st_ctime;
        }
    }

    public boolean isDirectory() {
        return (this.st_mode & 16384) == 16384;
    }

    public void makeItIsDir() {
        this.st_mode |= 16384;
    }

    public boolean isSymLink() {
        return (this.st_mode & 61440) == 40960;
    }
}
