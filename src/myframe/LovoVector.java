package myframe;

import java.util.Vector;
/**
 * ����м���
 * @author ibm
 *
 */
public class LovoVector extends Vector{
	/**������Ψһ��ʶid�����ڴ����в���ʾ*/
	private int key;
	
	public LovoVector(int key){
		this.key = key;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}
}
