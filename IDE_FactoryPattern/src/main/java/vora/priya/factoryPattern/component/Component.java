package vora.priya.factoryPattern.component;

//HTML 
//C-Sharp
abstract public class Component {
	private String len;
	private String width;
	private String top;
	private String left;
	private String context;

	public String getLen() {
		return len;
	}

	public void setLen(String len) {
		this.len = len;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getTop() {
		return top;
	}

	public void setTop(String top) {
		this.top = top;
	}

	public String getLeft() {
		return left;
	}

	public void setLeft(String left) {
		this.left = left;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	@Override
	public String toString() {
		return "Component [len=" + len + ", width=" + width + ", top=" + top + ", left=" + left + ", context=" + context
				+ "]";
	}
	
	
}
