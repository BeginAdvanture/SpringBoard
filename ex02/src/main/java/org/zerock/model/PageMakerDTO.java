package org.zerock.model;

import lombok.Data;

@Data
public class PageMakerDTO {
	/* ���� ������ */
	private int startPage;

	/* �� ������ */
	private int endPage;

	/* ���� ������, ���� ������ �������� */
	private boolean prev, next;

	/* ��ü �Խù� �� */
	private int total;

	/* ���� ������, �������� �Խù� ǥ�ü� ���� */
	private Criteria cri;
	
	
	private boolean first = true;
	private boolean finish = true;
	
	private int reFirst;
	private int reEnd;
	
	public PageMakerDTO(Criteria cri, int total) {
		
		this.cri = cri;
		this.total = total;

		/* ������ ������ */
		this.endPage = (int) (Math.ceil(cri.getPageNum() / 10.0)) * 10;
		/* ���� ������ */
		this.startPage = this.endPage - 9;
		
		this.reFirst = 1;
		this.reEnd = getTotal()/cri.getAmount()+1;
		
		/* ��ü ������ ������ */
		int realEnd = (int) (Math.ceil(total * 1.0 / cri.getAmount()));

		/*
		 * ��ü ������ ������(realend)�� ȭ�鿡 ���̴� ������������(endPage)���� ���� ���, ���̴� ������(endPage) �� ����
		 */
		if (realEnd < this.endPage) {
			this.endPage = realEnd;
		}

		/* ���� ������(startPage)���� 1���� ū ��� true */
		this.prev = this.startPage > 1;

		/* ������ ������(endPage)���� 1���� ū ��� true */
		this.next = this.endPage < realEnd;


		
	}
}
