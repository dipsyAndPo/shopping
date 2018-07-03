package cn.yyt.util;

public class Page {
	int start;//��ʼҳ��
	int count;//ÿҳ��ʾ����
	int total;//�ܸ���
	String param;//����
	
	private static final int defaultCount=5;

	
	public boolean isFirstPage(){
		if(start==0){
			return true;
		}
		return false;
		
	}
	
	public boolean isLastPage(){
		if(getLast()==start){
			return true;
		}
		return false;
	}
	
	
	//��ȡ��ҳ��
	public int getTotalPage(){
		int totalPage;
		if(total%count==0){
			totalPage=total/count;
		}else {
			totalPage=(total/count)+1;
		}
		totalPage=totalPage==0?1:totalPage;
		return totalPage;
	}
	
	public int getLast(){
		int last;
		if(total%count==0){
			last=total-count;
		}else{
			last=total-total%count;
		}
		last=last<0?0:last;
		return last;
	}
	
	
	
	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public Page() {
		count=defaultCount;
	}
	
	
}
