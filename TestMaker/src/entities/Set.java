package entities;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Set<T> implements Serializable {

    private static final long serialVersionUID = 4063328560719924348L;

    private T[] set;
    private int lastIndex;

    public Set(Class<T> clazz) {
        this.set = (T[]) Array.newInstance(clazz, 10);
        this.lastIndex = 0;
    }

    public T[] getSet() {
        return set;
    }

    public int getSize() {
        int num = 0;
        for(T obj: set){
            if(obj != null)
                num++;
        }
        return num;
    }

    public T get(int index){
        return set[index];
    }

    public void add(T type){
        if(doesObjectNotExist(type)){
            if (!doesSetHaveSpace()) {
                expandSet();
            }
            this.set[lastIndex] = type;
            this.lastIndex = this.lastIndex +1;
        }
    }

    public void remove(int index, Class<T> clazz){
        T[] copySet = (T[]) Array.newInstance(clazz, this.set.length-1);
        for(int i=0; i<index-1; i++){
            copySet[i] = this.set[i];
        }
        for(int i=index-1; i<copySet.length; i++){
            copySet[i] = this.set[i+1];
        }
        this.set = copySet;
        this.lastIndex = this.lastIndex -1;
    }

    private boolean doesObjectNotExist(T type) {
        for (T obj : this.set) {
            if (type.equals(obj)) {
                return false;
            }
        }
        return true;
    }

    private boolean doesSetHaveSpace() {
        for (T obj : set) {
            if (obj == null) return true;
        }
        return false;
    }

    private void expandSet(){
        int size = this.set.length;
        this.set = Arrays.copyOf(this.set, size*2);
    }

    public boolean equals(Set<T> other){
        if(other == null)
            return false;
        return Arrays.equals(this.getSet(), other.getSet());

    }

    @Override
    public String toString() {
        return "Set{" +
                "set=" + Arrays.toString(set) +
                '}';
    }

}
