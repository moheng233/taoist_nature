package xyz.moheng.taoist_nature.magic;

/* 术式的核心类
 *
 * 
 * 
 * 
 */
public class Magic {
    public MagicExec Exec; // 术式的执行单元
    public String Name;  // 术式的名字

    public Magic(String Name,MagicExec Exec) {
        this.Name = Name;

        this.Exec = Exec;
    }
}