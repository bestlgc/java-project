package nips;

public class PinYingRules {
	public static void main(String[] args) {
		String[] list = {"David Blei","Shakir Mohamed","Rajesh Ranganath","Zhe Li","Boqing Gong","Tianbao Yang","yun liu"};
		String reg = "bang|ba[ino]?|beng|be[in]?|bing|bia[no]?|bi[en]?|bu|cang|ca[ino]?|ceng|ce[in]?|chang|cha[ino]?|cheng|che[n]?|chi|chong|chou|chuang|chua[in]|chu[ino]?|ci|cong|cou|cuan|cu[ino]?|dang|da[ino]?|deng|de[in]?|dia[no]?|ding|di[ae]?|dong|dou|duan|du[ino]?|fang|fan|fa|feng|fe[in]{1}|fo[u]?|fu|gang|ga[ino]?|geng|ge[in]?|gong|gou|guang|gua[in]?|gu[ino]?|hang|ha[ino]?|heng|he[in]?|hong|hou|huang|hua[in]?|hu[ino]?|jiang|jia[no]?|jiong|ji[nu]?|juan|ju[en]?|kang|ka[ino]?|keng|ke[n]?|kong|kou|kuang|kua[in]?|ku[ino]?|lang|la[ino]?|leng|le[i]?|liang|lia[no]?|ling|li[enu]?|long|lou|luan|lu[no]?|lv[e]?|mang|ma[ino]?|meng|me[in]?|mia[no]?|ming|mi[nu]?|mo[u]?|mu|nang|na[ino]?|neng|ne[in]?|niang|nia[no]?|ning|ni[enu]?|nong|nou|nuan|nu[on]?|nv[e]?|pang|pa[ino]?|pa|peng|pe[in]?|ping|pia[no]?|pi[en]?|po[u]?|pu|qiang|qia[no]?|qiong|qing|qi[aenu]?|quan|qu[en]?|rang|ra[no]{1}|reng|re[n]?|rong|rou|ri|ruan|ru[ino]?|sang|sa[ino]?|seng|se[n]?|shang|sha[ino]?|sheng|she[in]?|shi|shou|shuang|shua[in]?|shu[ino]?|si|song|sou|suan|su[ino]?|tang|ta[ino]?|teng|te|ting|ti[e]?|tia[no]?|tong|tou|tuan|tu[ino]?|wang|wa[ni]?|weng|we[in]{1}|w[ou]{1}|xiang|xia[no]?|xiong|xing|xi[enu]?|xuan|xu[en]|yang|ya[no]?|ye|ying|yi[n]?|yong|you|yo|yuan|yu[en]?|zang|za[ino]?|zeng|ze[in]?|zhang|zha[ino]?|zheng|zhe[in]?|zhi|zhong|zhou|zhuang|zhua[in]?|zhu[ino]?|zi|zong|zou|zuan|zu[ino]?";
		for (int i = 0; i < list.length; i++) {
			String[] nameList = list[i].trim().split(" ");
			if (nameList.length>1) {
				System.out.println(nameList[1].toLowerCase().matches(reg));
			}else {
				System.out.println(false);
			}
		}
	}
}
