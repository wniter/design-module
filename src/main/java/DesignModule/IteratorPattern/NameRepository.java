package DesignModule.IteratorPattern;

/**
 * 创建实现了 Container 接口的实体类。该类有实现了 Iterator 接口的内部类 NameIterator。
 */
public class NameRepository implements Container {
    public String[] names = {"Robert" , "John" ,"Julie" , "Lora"};

    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {

        int index;


        public boolean hasNext() {
            if(index < names.length){
                return true;
            }
            return false;
        }


        public Object next() {
            if(this.hasNext()){
                return names[index++];
            }
            return null;
        }
    }
}