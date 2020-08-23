package com.leetcode;

/**
 * @author mai.gq
 * @date 2020/7/29
 */
public class Test {

    private String name;

    public Test(String name) {
        this.name = name;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

//    @Override
//    public boolean equals(Object obj) {
//
//        if (obj == null)
//            return false;
//        else {
//            if (obj instanceof Test) {
//                Test t = (Test) obj;
//                if (t.name == this.name) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    public static void main(String[] args) {

        Test x = new Test("x");
        Test y = new Test("x");
        System.out.println("x HashCode="+x.hashCode());
        System.out.println("y HashCode="+y.hashCode());
        System.out.println(x.equals(y) == true);
        String s = "2";
        String sd = "3";
        System.out.println(s.equals(sd));
		/*String name1 = new String("张三");
		String name2 = new String("张三");
		System.out.println(name1.equals(name2));
		System.err.println(name1.hashCode());
		System.err.println(name2.hashCode());*/
    }

}