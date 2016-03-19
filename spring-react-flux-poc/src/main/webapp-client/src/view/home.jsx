import React from "react";
import {Link} from "react-router";
import FrameworkTable from "../components/FrameworkTable.jsx";

class Home extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            items: [1, 2, 3]
        };
    }

    render() {
        return (
            <div className="row">
                <div className="col-md-3">
                    <div className="list-group">
                        <Link to="/" className="list-group-item active">Framework List</Link>
                        <Link to="add" className="list-group-item">Add Framework</Link>
                        <Link to="search" className="list-group-item">Search</Link>
                    </div>
                </div>
                <div className="col-md-8">
                    <FrameworkTable {...this.state}/>
                </div>
            </div>
        );
    }
}

export default Home;