import React from "react";
import Menu from "../components/Menu.jsx";


class Add extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            active: 2
        };
    }

    render() {
        return (
            <div className="row">
                <Menu  {...this.state}/>
                <div className="col-md-8">
                    <div className="well">
                        <h4>Add New Framework</h4>

                        <form name="addFramework" method="post">
                            <div className="control-group form-group">
                                <div className="controls">
                                    <label htmlFor="name">Name:</label>
                                    <input type="text" className="form-control" id="name"/>

                                    <p className="help-block"/>
                                </div>
                            </div>
                            <div className="control-group form-group">
                                <div className="controls">
                                    <label htmlFor="description">Description:</label>
                                    <textarea className="form-control" rows="3" id="description"/>

                                    <div className="help-block"></div>
                                </div>
                            </div>
                            <div className="control-group form-group">
                                <div className="controls">
                                    <label htmlFor="docLink">Documentation Link:</label>
                                    <input type="text" className="form-control" id="docLink"/>

                                    <div className="help-block"></div>
                                </div>
                            </div>
                            <div className="control-group form-group">
                                <label htmlFor="categorySelect">Category:</label>
                                <select className="form-control" id="categorySelect">
                                    <option>Web Layer</option>
                                    <option>Service Layer</option>
                                    <option>Data Layer</option>
                                </select>
                            </div>
                            <div id="success"></div>
                            <button type="submit" className="btn btn-primary">Save</button>
                        </form>
                    </div>
                </div>
            </div>
        );
    }
}

export default Add;