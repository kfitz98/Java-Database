package assignment;

public class NCT {
	
	private String c;
	private int p,f,fd,total;
	private double pp,fp,fdp;
	
	public NCT(String c, int p, double pp, int f, double fp, int fd, double fdp, int total)
	{
		this.c=c;
		this.p=p;
		this.pp=pp;
		this.f=f;
		this.fp=fp;
		this.fd=fd;
		this.fdp=fdp;
		this.total=total;
	}

	public String getC() {
		return c;
	}

	public int getP() {
		return p;
	}

	public int getF() {
		return f;
	}

	public int getFd() {
		return fd;
	}

	public int getTotal() {
		return total;
	}

	public double getPp() {
		return pp;
	}

	public double getFp() {
		return fp;
	}

	public double getFdp() {
		return fdp;
	}
}
