class myHeader extends HTMLElement{
    connectedCallback(){
        this.innerHTML = '<header>\n\
    <img src="Styles/logo.PNG" alt="logo" style="width:200px;height:200px;"></img>\n\
    </header>\n\
    '
        
    }
}
customElements.define('my-header', myHeader);

class myFooter extends HTMLElement{
    connectedCallback(){
        this.innerHTML = '<footer>\n\
    © 2022 Fororueda\n\
    </footer>\n\
    '
        
    }
}
customElements.define('my-footer', myFooter);