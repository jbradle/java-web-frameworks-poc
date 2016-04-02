import React from "react";
import Menu from "../components/Menu.jsx";
import linkParams from "./linkParams.jsx";
import FrameworkEdit from "../components/FrameworkEdit.jsx";

class Add extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            framework: {category: {}},
            categories: []
        };

    }

    render() {
        return (
            <div className="row">
                <Menu  {...{active : 2, linkParams : linkParams}}/>
                <div className="col-md-8">
                    <FrameworkEdit {...this.state}/>
                </div>
            </div>
        );
    }
}

export default Add;